package mg.tana.location.infrastructure.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mg.tana.location.application.port.out.EventStorePort;
import mg.tana.location.domain.event.EventEntity;

import java.util.List;

@ApplicationScoped
public class EventStoreAdapter implements EventStorePort {

    @Inject
    ObjectMapper objectMapper;

    @Override
    @Transactional
    public void append(String eventType, Long aggregateId, Object payload) {
        try {
            EventEntity event = new EventEntity();
            event.setEventType(eventType);
            event.setAggregateId(aggregateId);
            event.setPayload(objectMapper.writeValueAsString(payload));

            event.persist();

        } catch (JsonProcessingException e) {
            throw new IllegalStateException("error persisting event ", e);
        }
    }

    @Override
    public List<EventEntity> readAll() {

        return EventEntity.listAll();
    }
}
