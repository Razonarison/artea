package mg.tana.location.application.command;

import mg.tana.location.domain.model.type.ContratType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateContratCommand(
        ContratType type,
        LocalDate debutContrat,
        LocalDate finContrat,
        BigDecimal salaireBase,
        boolean valide
) {
}
