package mg.tana.location.application.port.in;

import mg.tana.location.application.command.CreateProduitCommand;
import mg.tana.location.domain.model.Produit;

import java.util.List;

public interface ProduitManagementUseCase {

    Produit createProduit(CreateProduitCommand command);

    List<Produit> listProduits();

    Produit getProduit(Long id);
}
