package mg.tana.location.application.port.out;

import mg.tana.location.domain.model.Produit;
import mg.tana.location.infrastructure.in.rest.dto.response.ProduitListResponse;

import java.util.List;
import java.util.Optional;

public interface ProduitRepositoryPort {

    Produit save(Produit produit);

    Optional<Produit> findById(Long id);

    List<ProduitListResponse> findAll();
}
