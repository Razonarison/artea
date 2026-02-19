package mg.tana.location.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contrat")
public class Contrat extends AggregateRoot {
    private String type;
    private LocalDate debutContrat;
    private LocalDate finContrat;
    private BigDecimal salaireBase;

    public Contrat() {
    }

    public Contrat(Long id, String type, LocalDate debutContrat, LocalDate finContrat, BigDecimal salaireBase, boolean valide) {
        super(id, valide);
        this.type = type;
        this.debutContrat = debutContrat;
        this.finContrat = finContrat;
        this.salaireBase = salaireBase;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDebutContrat() {
        return debutContrat;
    }

    public void setDebutContrat(LocalDate debutContrat) {
        this.debutContrat = debutContrat;
    }

    public LocalDate getFinContrat() {
        return finContrat;
    }

    public void setFinContrat(LocalDate finContrat) {
        this.finContrat = finContrat;
    }

    public BigDecimal getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(BigDecimal salaireBase) {
        this.salaireBase = salaireBase;
    }
}
