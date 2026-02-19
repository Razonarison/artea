package mg.tana.location.infrastructure.in.rest.dto;

import java.time.LocalDate;

public record CreateUserRequest (
        String nom,
        String prenom,
        LocalDate dateNaissance,
        String cin,
        Long contratId,
        boolean valide
) {
}
