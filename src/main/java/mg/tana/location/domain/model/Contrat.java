package mg.tana.location.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import mg.tana.location.application.service.FormatNumber;
import mg.tana.location.domain.model.type.ContratType;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "contrat")
public class Contrat extends AggregateRoot {
    @Enumerated(EnumType.STRING)
    private ContratType type;
    private LocalDate debutContrat;
    private LocalDate finContrat;
    @FormatNumber()
    private BigDecimal salaireBase;

    public Contrat() {
        super.setValide(true);
    }

    public Contrat(Long id, ContratType type, LocalDate debutContrat, LocalDate finContrat, BigDecimal salaireBase, boolean valide) {
        super(id, valide);
        this.type = type;
        this.debutContrat = debutContrat;
        this.finContrat = finContrat;
        this.salaireBase = salaireBase;
    }

    public ContratType getType() {
        return type;
    }

    public void setType(ContratType type) {
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
