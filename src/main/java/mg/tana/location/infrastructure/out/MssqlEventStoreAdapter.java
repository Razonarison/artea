package mg.tana.location.infrastructure.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import mg.tana.location.application.port.out.EventStorePort;
import mg.tana.location.domain.event.EventEntity;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class MssqlEventStoreAdapter implements EventStorePort {

    private final EntityManager entityManager;
    private final ObjectMapper objectMapper;

    public MssqlEventStoreAdapter(EntityManager entityManager, ObjectMapper objectMapper) {
        this.entityManager = entityManager;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public void append(UUID aggregateId, String eventType, Object payload) {
        try {
            entityManager.persist(new EventEntity(
                    UUID.randomUUID(),
                    aggregateId,
                    eventType,
                    objectMapper.writeValueAsString(payload)
            ));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Impossible d'écrire un événement dans MSSQL", e);
        }
    }

    @Override
    public List<EventEntity> readAll() {
        return entityManager.createQuery("SELECT e FROM EventEntity e ORDER BY e.id", EventEntity.class)
                .getResultList();
    }
}
