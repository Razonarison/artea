package mg.tana.location.infrastructure.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import mg.tana.location.application.port.out.ProduitRepositoryPort;
import mg.tana.location.domain.model.Produit;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class HibernateProduitRepositoryAdapter implements ProduitRepositoryPort {

    private final EntityManager entityManager;

    public HibernateProduitRepositoryAdapter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Produit save(Produit produit) {
        Produit existing = entityManager.find(Produit.class, produit.getId());
        if (existing == null) {
            entityManager.persist(produit);
            return produit;
        }
        return entityManager.merge(produit);
    }

    @Override
    public Optional<Produit> findById(UUID id) {
        return Optional.ofNullable(entityManager.find(Produit.class, id));
    }

    @Override
    public List<Produit> findAll() {
        return entityManager.createQuery("SELECT p FROM Produit p", Produit.class).getResultList();
    }
}
