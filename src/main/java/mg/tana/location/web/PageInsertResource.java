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
import mg.tana.location.domain.model.User;

import java.util.Map;

@Path("add")
@Produces(MediaType.TEXT_HTML)
public class PageInsertResource {

    @Inject
    @Location("pub/page-insert.html")
    Template pageInsert;

    @GET
    @Path("user")
    public TemplateInstance makeInsertUser() {
        Map<String, Object> data = PageUtil.magePageInsert(User.class);
        return pageInsert.data("data", data);
    }

}
