package mg.tana.location.web;

import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.domain.model.Produit;
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
        return pageInsert.data("title", "Ajout utilisateur", "data", data);
    }

    @GET
    @Path("contract")
    public TemplateInstance makeInsertContract() {
        Map<String, Object> data = PageUtil.magePageInsert(Contrat.class);
        return pageInsert.data("title", "Ajout contrat", "data", data);
    }

    @GET
    @Path("product")
    public TemplateInstance makeInsertProduct() {
        Map<String, Object> data = PageUtil.magePageInsert(Produit.class);
        return pageInsert.data("title", "Ajout produit", "data", data);
    }

}
