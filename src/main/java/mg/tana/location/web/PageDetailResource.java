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

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class PageDetailResource {

    @Inject
    @Location("pub/page-detail.html")
    Template pageDetail;

    @GET
    @Path("/users/{id}")
    public TemplateInstance showDetailUser(@PathParam("id") Long id) {
        return pageDetail.data("id", id);
    }

    @GET
    @Path("/products/{id}")
    public TemplateInstance showDetailProduct(@PathParam("id") Long id) {
        return pageDetail.data("id", id);
    }

    @GET
    @Path("/contracts/{id}")
    public TemplateInstance showDetailContract(@PathParam("id") Long id) {
        return pageDetail.data("id", id);
    }

}
