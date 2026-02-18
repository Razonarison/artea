package mg.tana.location.infrastructure.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import mg.tana.location.application.port.out.UserRepositoryPort;
import mg.tana.location.domain.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class HibernateUserRepositoryAdapter implements UserRepositoryPort {

    private final EntityManager entityManager;

    public HibernateUserRepositoryAdapter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public User save(User user) {
        User existing = entityManager.find(User.class, user.getId());
        if (existing == null) {
            entityManager.persist(user);
            return user;
        }
        return entityManager.merge(user);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}
