package mg.tana.location.domain.event.type;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ContratCreatedEvent(
        UUID contratId,
        String type,
        LocalDate debutContrat,
        LocalDate finContrat,
        BigDecimal salaireBase,
        boolean valide
) {
}
