package mg.tana.location.application.port.out;

import mg.tana.location.domain.event.EventEntity;

import java.util.List;

public interface EventStorePort {

    void append(String eventType, Long aggregateId, Object payload);

    List<EventEntity> readAll();
}
