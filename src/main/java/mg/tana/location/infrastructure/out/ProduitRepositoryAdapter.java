package mg.tana.location.infrastructure.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import mg.tana.location.application.port.out.ProduitRepositoryPort;
import mg.tana.location.domain.model.Produit;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProduitRepositoryAdapter implements ProduitRepositoryPort {

    @Override
    @Transactional
    public Produit save(Produit produit) {
        if (produit.getId() == null) {
            produit.persist();
            return produit;
        }

        Produit existing = Produit.findById(produit.getId());
        if (existing == null) {
            produit.persist();
            return produit;
        }

        existing.setCategorie(produit.getCategorie());
        existing.setSousCategorie(produit.getSousCategorie());
        existing.setItemDescription(produit.getItemDescription());
        existing.setPuAchat(produit.getPuAchat());
        existing.setPuLocation(produit.getPuLocation());
        existing.setPuCaution(produit.getPuCaution());
        existing.setLienAchat(produit.getLienAchat());
        existing.setValide(produit.isValide());

        return existing;
    }

    @Override
    public Optional<Produit> findById(Long id) {
        return Optional.ofNullable(Produit.findById(id));
    }

    @Override
    public List<Produit> findAll() {
        return Produit.listAll();
    }
}
