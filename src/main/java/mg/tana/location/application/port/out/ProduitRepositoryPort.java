package mg.tana.location.application.port.out;

import mg.tana.location.domain.model.Produit;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProduitRepositoryPort {

    Produit save(Produit produit);

    Optional<Produit> findById(UUID id);

    List<Produit> findAll();
}
