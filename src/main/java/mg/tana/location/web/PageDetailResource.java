package mg.tana.location.web;

import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mg.tana.location.application.service.LocationManagementService;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.domain.model.Produit;
import mg.tana.location.domain.model.User;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class PageDetailResource {

    @Inject
    @Location("pub/page-detail.html")
    Template pageDetail;

    @Inject
    LocationManagementService locationManagementService;

    @GET
    @Path("/users/{id}")
    public TemplateInstance showDetailUser(@PathParam("id") Long id) {
        User user = locationManagementService.findUser(id);
        return pageDetail.data("id", id, "data", user);
    }

    @GET
    @Path("/products/{id}")
    public TemplateInstance showDetailProduct(@PathParam("id") Long id) {
        Produit produit = locationManagementService.getProduit(id);
        return pageDetail.data("id", id, "data", produit);
    }

    @GET
    @Path("/contracts/{id}")
    public TemplateInstance showDetailContract(@PathParam("id") Long id) {
        Contrat contrat = locationManagementService.getContrat(id);
        return pageDetail.data("id", id, "data", contrat);
    }

}
