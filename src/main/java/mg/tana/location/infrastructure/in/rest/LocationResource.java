package mg.tana.location.infrastructure.in.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mg.tana.location.application.command.AssignContratToUserCommand;
import mg.tana.location.application.command.CreateContratCommand;
import mg.tana.location.application.command.CreateProduitCommand;
import mg.tana.location.application.command.CreateUserCommand;
import mg.tana.location.application.port.in.ContratManagementUseCase;
import mg.tana.location.application.port.in.EventQueryUseCase;
import mg.tana.location.application.port.in.ProduitManagementUseCase;
import mg.tana.location.application.port.in.UserManagementUseCase;
import mg.tana.location.domain.event.EventEntity;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.domain.model.Produit;
import mg.tana.location.domain.model.User;
import mg.tana.location.infrastructure.in.rest.dto.AssignContratRequest;
import mg.tana.location.infrastructure.in.rest.dto.CreateContratRequest;
import mg.tana.location.infrastructure.in.rest.dto.CreateProduitRequest;
import mg.tana.location.infrastructure.in.rest.dto.CreateUserRequest;

import java.util.List;
import java.util.UUID;

@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LocationResource {

    @Inject
    UserManagementUseCase userManagement;

    @Inject
    ContratManagementUseCase contratManagement;

    @Inject
    ProduitManagementUseCase produitManagement;

    @Inject
    EventQueryUseCase eventQuery;

    @POST
    @Path("/users")
    public User createUser(CreateUserRequest request) {
        return userManagement.createUser(new CreateUserCommand(
                request.nom(),
                request.prenom(),
                request.dateNaissance(),
                request.cin(),
                request.valide()
        ));
    }

    @GET
    @Path("/users")
    public List<User> listUsers() {
        return userManagement.listUsers();
    }

    @POST
    @Path("/users/{userId}/contrat")
    public User assignContrat(@PathParam("userId") UUID userId, AssignContratRequest request) {
        return userManagement.assignContratToUser(new AssignContratToUserCommand(userId, request.contratId()));
    }

    @POST
    @Path("/contrats")
    public Contrat createContrat(CreateContratRequest request) {
        return contratManagement.createContrat(new CreateContratCommand(
                request.type(),
                request.debutContrat(),
                request.finContrat(),
                request.salaireBase(),
                request.valide()
        ));
    }

    @GET
    @Path("/contrats")
    public List<Contrat> listContrats() {
        return contratManagement.listContrats();
    }

    @POST
    @Path("/produits")
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
    @Path("/produits")
    public List<Produit> listProduits() {
        return produitManagement.listProduits();
    }

    @GET
    @Path("/events")
    public List<EventEntity> listEvents() {
        return eventQuery.listEvents();
    }
}
