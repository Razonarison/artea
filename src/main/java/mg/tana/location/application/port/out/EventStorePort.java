package mg.tana.location.application.port.out;

import mg.tana.location.domain.event.EventEntity;

import java.util.List;
import java.util.UUID;

public interface EventStorePort {

    void append(UUID aggregateId, String eventType, Object payload);

    List<EventEntity> readAll();
}
