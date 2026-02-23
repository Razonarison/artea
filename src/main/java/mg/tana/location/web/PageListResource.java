package mg.tana.location.web;

import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mg.tana.location.application.service.Util;
import mg.tana.location.application.service.LocationManagementService;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.domain.model.Produit;
import mg.tana.location.domain.model.User;

import java.util.List;

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
        List<User> users = managementService.listUsers();
        List<String> headers = Util.getClassFieldsString(User.class);

        return listePage.data("title", User.class.getSimpleName(), "headers", headers, "users", users);
    }

    @GET
    @Path("contracts")
    public TemplateInstance makeListeContrats() throws IllegalAccessException {
        List<Contrat> contrats = managementService.listContrats();
        List<String> headers = Util.getClassFieldsString(Contrat.class);

        return listePage.data("title", Contrat.class.getSimpleName(), "headers", headers);
    }

    @GET
    @Path("products")
    public TemplateInstance makeListeProduits() throws IllegalAccessException {
        List<Produit> produits = managementService.listProduits();
        List<String> headers = Util.getClassFieldsString(Produit.class);

        return listePage.data("title", Produit.class.getSimpleName(), "headers", headers);
    }

}
