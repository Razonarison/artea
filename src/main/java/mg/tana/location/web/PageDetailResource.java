package mg.tana.location.web;

import java.util.Map;

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
import mg.tana.location.infrastructure.in.rest.dto.response.UserDetailResponse;

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
    public TemplateInstance showDetailUser(@PathParam("id") Long id) throws IllegalAccessException {
        UserDetailResponse user = locationManagementService.findUserDetails(id);
        Map<String, Object> data = PageUtil.makePageDetail(user);
        return pageDetail.data("id", id, "data", data);
    }

    @GET
    @Path("/products/{id}")
    public TemplateInstance showDetailProduct(@PathParam("id") Long id) throws IllegalAccessException {
        Produit produit = locationManagementService.getProduit(id);
        Map<String, Object> data = PageUtil.makePageDetail(produit);
        return pageDetail.data("id", id, "data", data);
    }

    @GET
    @Path("/contracts/{id}")
    public TemplateInstance showDetailContract(@PathParam("id") Long id) throws IllegalAccessException {
        Contrat contrat = locationManagementService.getContrat(id);
        Map<String, Object> data = PageUtil.makePageDetail(contrat);
        return pageDetail.data("id", id, "data", data);
    }

}
