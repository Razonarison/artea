package mg.tana.location.application.port.in;

import mg.tana.location.application.command.CreateProduitCommand;
import mg.tana.location.domain.model.Produit;
import mg.tana.location.infrastructure.in.rest.dto.response.ProduitListResponse;

import java.util.List;

public interface ProduitManagementUseCase {

    Produit createProduit(CreateProduitCommand command);

    List<ProduitListResponse> listProduits();

    Produit getProduit(Long id);
}
