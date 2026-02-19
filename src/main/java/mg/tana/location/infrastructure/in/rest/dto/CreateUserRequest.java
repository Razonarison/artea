package mg.tana.location.infrastructure.in.rest.dto;

import mg.tana.location.domain.model.Contrat;

import java.time.LocalDate;

public record CreateUserRequest (
        String nom,
        String prenom,
        LocalDate dateNaissance,
        String cin,
        Contrat contrat
) {
}
