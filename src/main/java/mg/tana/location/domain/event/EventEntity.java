package mg.tana.location.domain.event;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "event_store")
public class EventEntity extends PanacheEntity {

    private String eventType;
    private Long aggregateId;
    @Lob
    private String payload;
    private Instant occuredOn;

    public EventEntity() {
        this.occuredOn = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(Long aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Instant getOccuredOn() {
        return occuredOn;
    }

    public void setOccuredOn(Instant occuredOn) {
        this.occuredOn = occuredOn;
    }
}
