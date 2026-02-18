package mg.tana.location.infrastructure.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import mg.tana.location.application.port.out.ContratRepositoryPort;
import mg.tana.location.domain.model.Contrat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class HibernateContratRepositoryAdapter implements ContratRepositoryPort {

    private final EntityManager entityManager;

    public HibernateContratRepositoryAdapter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Contrat save(Contrat contrat) {
        Contrat existing = entityManager.find(Contrat.class, contrat.getId());
        if (existing == null) {
            entityManager.persist(contrat);
            return contrat;
        }
        return entityManager.merge(contrat);
    }

    @Override
    public Optional<Contrat> findById(UUID id) {
        return Optional.ofNullable(entityManager.find(Contrat.class, id));
    }

    @Override
    public List<Contrat> findAll() {
        return entityManager.createQuery("SELECT c FROM Contrat c", Contrat.class).getResultList();
    }
}
