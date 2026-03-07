package mg.tana.location.infrastructure.in.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mg.tana.location.domain.model.Commande;

@Path("/api/commandes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommandeResource {

    @POST
    public Commande createCommandeClient() {
        return null;
    }
}
