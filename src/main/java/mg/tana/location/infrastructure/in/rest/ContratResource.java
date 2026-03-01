package mg.tana.location.infrastructure.in.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mg.tana.location.application.command.CreateContratCommand;
import mg.tana.location.application.port.in.ContratManagementUseCase;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.infrastructure.in.rest.dto.CreateContratRequest;

import java.util.List;

@Path("api/contrats")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContratResource {

    @Inject
    ContratManagementUseCase contratManagement;

    @POST
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
    public List<Contrat> listContrats() {
        return contratManagement.listContrats();
    }

    @GET
    @Path("/{id}")
    public Contrat getSpecifiqueContrat(@QueryParam("id") Long id) {
        return contratManagement.getContrat(id);
    }
}
