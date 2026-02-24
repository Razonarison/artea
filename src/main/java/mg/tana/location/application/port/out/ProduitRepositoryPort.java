package mg.tana.location.application.port.out;

import mg.tana.location.domain.model.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitRepositoryPort {

    Produit save(Produit produit);

    Optional<Produit> findById(Long id);

    List<Produit> findAll();
}
