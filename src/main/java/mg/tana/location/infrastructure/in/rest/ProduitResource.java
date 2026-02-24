package mg.tana.location.infrastructure.in.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mg.tana.location.application.command.CreateProduitCommand;
import mg.tana.location.application.port.in.ProduitManagementUseCase;
import mg.tana.location.domain.model.Produit;
import mg.tana.location.infrastructure.in.rest.dto.CreateProduitRequest;

import java.util.List;

@Path("api/produits")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProduitResource {

    @Inject
    ProduitManagementUseCase produitManagement;

    @POST
    public Produit createProduit(CreateProduitRequest request) {
        return produitManagement.createProduit(new CreateProduitCommand(
                request.categorie(),
                request.sousCategorie(),
                request.itemDescription(),
                request.puAchat(),
                request.puLocation(),
                request.puCaution(),
                request.lienAchat()
        ));
    }

    @GET
    public List<Produit> listProduits() {
        return produitManagement.listProduits();
    }
}
