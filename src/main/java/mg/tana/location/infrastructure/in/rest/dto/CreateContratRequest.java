package mg.tana.location.infrastructure.in.rest.dto;

import mg.tana.location.domain.model.type.ContratType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateContratRequest(
        ContratType type,
        LocalDate debutContrat,
        LocalDate finContrat,
        BigDecimal salaireBase,
        boolean valide
) {
}
