package mg.tana.location.application.port.in;

import jakarta.enterprise.context.ApplicationScoped;
import mg.tana.location.domain.event.EventEntity;

import java.util.List;

@ApplicationScoped
public class EventQueryUseCaseImpl implements EventQueryUseCase {
    @Override
    public List<EventEntity> listEvents() {
        return List.of();
    }
}
