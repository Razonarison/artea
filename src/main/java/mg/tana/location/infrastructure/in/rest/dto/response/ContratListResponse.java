package mg.tana.location.infrastructure.in.rest.dto.response;

import mg.tana.location.application.service.ChampLibelle;
import mg.tana.location.application.service.FormatNumber;
import mg.tana.location.domain.model.type.ContratType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContratListResponse {
    private Long id;
    private ContratType type;
    @ChampLibelle("Début validité contrat")
    private LocalDate debutContrat;
    @ChampLibelle("Fin validité contrat")
    private LocalDate finContrat;
    @ChampLibelle("Salaire de base")
    @FormatNumber()
    private BigDecimal salaireBase;

    public ContratListResponse(Long id, ContratType type, LocalDate debutContrat, LocalDate finContrat, BigDecimal salaireBase) {
        this.id = id;
        this.type = type;
        this.debutContrat = debutContrat;
        this.finContrat = finContrat;
        this.salaireBase = salaireBase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
