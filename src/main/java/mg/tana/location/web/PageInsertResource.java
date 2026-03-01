package mg.tana.location.web;

import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mg.tana.location.application.command.CreateContratCommand;
import mg.tana.location.application.command.CreateProduitCommand;
import mg.tana.location.application.command.CreateUserCommand;
import mg.tana.location.application.port.in.ContratManagementUseCase;
import mg.tana.location.application.port.in.ProduitManagementUseCase;
import mg.tana.location.application.port.in.UserManagementUseCase;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.domain.model.Produit;
import mg.tana.location.domain.model.User;
import mg.tana.location.domain.model.type.ContratType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("add")
@Produces(MediaType.TEXT_HTML)
public class PageInsertResource {

    @Inject
    UserManagementUseCase userManagement;

    @Inject
    ContratManagementUseCase contratManagement;

    @Inject
    ProduitManagementUseCase produitManagement;

    @Inject
    @Location("pub/page-insert.html")
    Template pageInsert;

    @GET
    @Path("user")
    public TemplateInstance makeInsertUser() {
        Map<String, Object> data = PageUtil.magePageInsert(User.class);
        List<String> fieldNames = (List<String>) data.get("fieldNames");
        List<List<String>> options = new ArrayList<>((List<List<String>>) data.get("options"));

        int contratFieldIndex = fieldNames.indexOf("contrat");
        if (contratFieldIndex >= 0) {
            List<String> contratOptions = Contrat.<Contrat>listAll().stream()
                    .map(contrat -> String.valueOf(contrat.getId()))
                    .toList();

            options.set(contratFieldIndex, contratOptions);
        }

        data.put("options", options);

        return pageInsert.data(
                "title", "Ajout utilisateur",
                "pageAppelInsert", "/api/users",
                "pageAppelListe", "/list/users",
                "data", data);

    }

    @GET
    @Path("contract")
    public TemplateInstance makeInsertContract() {
        Map<String, Object> data = PageUtil.magePageInsert(Contrat.class);
        return pageInsert.data(
                "title", "Ajout contrat",
                "pageAppelInsert", "/api/contrats",
                "pageAppelListe", "/list/contracts",
                "data", data);
    }

    @GET
    @Path("product")
    public TemplateInstance makeInsertProduct() {
        Map<String, Object> data = PageUtil.magePageInsert(Produit.class);
        return pageInsert.data(
                "title", "Ajout produit",
                "pageAppelInsert", "/api/produits",
                "pageAppelListe", "/list/products",
                "data", data);

    }

}
