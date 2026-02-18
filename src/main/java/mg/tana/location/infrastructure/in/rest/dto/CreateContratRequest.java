package mg.tana.location.infrastructure.in.rest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateContratRequest(
        String type,
        LocalDate debutContrat,
        LocalDate finContrat,
        BigDecimal salaireBase,
        boolean valide
) {
}
