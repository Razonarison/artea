package mg.tana.location.web;

import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mg.tana.location.application.command.Util;
import mg.tana.location.application.port.in.UserManagementUseCase;
import mg.tana.location.application.service.LocationManagementService;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.domain.model.Produit;
import mg.tana.location.domain.model.User;

import java.lang.reflect.Field;
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
    public TemplateInstance makeListeUsers() {
        List<User> users = managementService.listUsers();
        List<String> headers = Util.getClassFieldsString(User.class);

        return listePage.data("title", User.class.getSimpleName(), "headers", headers);
    }

    @GET
    @Path("contracts")
    public TemplateInstance makeListeContrats() {
        List<Contrat> contrats = managementService.listContrats();
        List<String> headers = Util.getClassFieldsString(Contrat.class);

        return listePage.data("title", Contrat.class.getSimpleName(), "headers", headers);
    }

    @GET
    @Path("products")
    public TemplateInstance makeListeProduits() {
        List<Produit> produits = managementService.listProduits();
        List<String> headers = Util.getClassFieldsString(Produit.class);

        return listePage.data("title", Produit.class.getSimpleName(), "headers", headers);
    }

}
