package mg.tana.location.domain.event.type;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContratCreatedEvent(
        Long contratId,
        String type,
        LocalDate debutContrat,
        LocalDate finContrat,
        BigDecimal salaireBase,
        boolean valide
) {
}
