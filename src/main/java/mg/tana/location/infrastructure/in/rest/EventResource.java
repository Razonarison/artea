package mg.tana.location.infrastructure.in.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mg.tana.location.application.port.in.EventQueryUseCase;
import mg.tana.location.domain.event.EventEntity;

import java.util.List;

@Path("events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource {

    @Inject
    EventQueryUseCase eventQuery;

    @GET
    public List<EventEntity> listEvents() {
        return eventQuery.listEvents();
    }
}
