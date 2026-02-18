package mg.tana.location.application.command;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateContratCommand(
        String type,
        LocalDate debutContrat,
        LocalDate finContrat,
        BigDecimal salaireBase,
        boolean valide
) {
}
