package mg.tana.location.web;

import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mg.tana.location.application.service.LocationManagementService;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.domain.model.Produit;
import mg.tana.location.domain.model.User;
import mg.tana.location.infrastructure.in.rest.dto.response.ContratListResponse;
import mg.tana.location.infrastructure.in.rest.dto.response.ProduitListResponse;
import mg.tana.location.infrastructure.in.rest.dto.response.UserListResponse;

import java.util.List;
import java.util.Map;

@Path("list")
@Produces(MediaType.TEXT_HTML)
public class PageListResource {

    @Inject
    LocationManagementService managementService;

    @Inject
    @Location("pub/page-liste.html")
    Template listePage;

    @GET
    @Path("users")
    public TemplateInstance makeListeUsers() throws IllegalAccessException {
        List<UserListResponse> users = managementService.listUsers();
        Map<String, Object> data = PageUtil.makePageList(users, UserListResponse.class);
        List<ChampMeta> champsRecherche = PageUtil.makeChampsRecherche(UserListResponse.class);
        return listePage.data(
                "title", User.class.getSimpleName(),
                "data", data,
                "pageInsertAppel", "/add/user",
                "pageDetailAppel", "/users",
                "champsRecherche", champsRecherche
        );
    }

    @GET
    @Path("contracts")
    public TemplateInstance makeListeContrats() throws IllegalAccessException {
        List<ContratListResponse> contrats = managementService.listContrats();
        Map<String, Object> data = PageUtil.makePageList(contrats, ContratListResponse.class);
        List<ChampMeta> champsRecherche = PageUtil.makeChampsRecherche(ContratListResponse.class);
        return listePage.data(
                "title", Contrat.class.getSimpleName(),
                "data", data,
                "pageInsertAppel", "/add/contract",
                "pageDetailAppel", "/contracts",
                "champsRecherche", champsRecherche
        );
    }

    @GET
    @Path("products")
    public TemplateInstance makeListeProduits() throws IllegalAccessException {
        List<ProduitListResponse> produits = managementService.listProduits();
        Map<String, Object> data = PageUtil.makePageList(produits, ProduitListResponse.class);
        List<ChampMeta> champsRecherche = PageUtil.makeChampsRecherche(ProduitListResponse.class);
        return listePage.data(
                "title", Produit.class.getSimpleName(),
                "data", data,
                "pageInsertAppel", "/add/product",
                "pageDetailAppel", "/products",
                "champsRecherche", champsRecherche
        );
    }

}
