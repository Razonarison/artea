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
import mg.tana.location.application.command.CreateUserCommand;
import mg.tana.location.application.port.in.UserManagementUseCase;
import mg.tana.location.domain.model.User;
import mg.tana.location.infrastructure.in.rest.dto.AssignContratRequest;
import mg.tana.location.infrastructure.in.rest.dto.CreateUserRequest;

import java.util.List;

@Path("api/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserManagementUseCase userManagement;

    @POST
    public User createUser(CreateUserRequest request) {
        return userManagement.createUser(new CreateUserCommand(
                request.nom(),
                request.prenom(),
                request.dateNaissance(),
                request.dateEmbauche(),
                request.cin(),
                request.contratId(),
                request.valide()
        ));
    }

    @GET
    public List<User> listUsers() {
        return userManagement.listUsers();
    }

    @GET
    @Path("/{userId}")
    public User findUser(@PathParam("userId") Long userId) {
        return userManagement.findUser(userId);
    }

    @POST
    @Path("/{userId}/contrat")
    public User assignContrat(@PathParam("userId") Long userId, AssignContratRequest request) {
        return userManagement.assignContratToUser(new AssignContratToUserCommand(userId, request.contratId()));
    }
}
