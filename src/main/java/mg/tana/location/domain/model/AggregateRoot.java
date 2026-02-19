package mg.tana.location.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AggregateRoot extends PanacheEntity {

    private boolean valide;

    protected AggregateRoot() {
    }

    protected AggregateRoot(Long id) {
        this.id = id;
    }

    protected AggregateRoot(Long id, boolean valide) {
        this.id = id;
        this.valide = valide;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }
}
