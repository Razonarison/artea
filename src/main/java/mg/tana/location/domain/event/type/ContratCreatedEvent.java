package mg.tana.location.domain.event.type;

import mg.tana.location.domain.model.type.ContratType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContratCreatedEvent(
        Long contratId,
        ContratType type,
        LocalDate debutContrat,
        LocalDate finContrat,
        BigDecimal salaireBase,
        boolean valide
) {
}
