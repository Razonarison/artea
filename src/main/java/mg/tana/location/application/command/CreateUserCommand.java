package mg.tana.location.application.command;

import mg.tana.location.domain.model.Contrat;

import java.time.LocalDate;

public record CreateUserCommand(
        String nom,
        String prenom,
        LocalDate dateNaissance,
        String cin,
        Contrat contrat
) {
}
