package mg.tana.location.application.port.in;

import mg.tana.location.domain.event.EventEntity;

import java.util.List;

public interface EventQueryUseCase {

    List<EventEntity> listEvents();
}
