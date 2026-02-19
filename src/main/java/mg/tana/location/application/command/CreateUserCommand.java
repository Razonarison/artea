package mg.tana.location.application.command;

import java.time.LocalDate;

public record CreateUserCommand(
        String nom,
        String prenom,
        LocalDate dateNaissance,
        LocalDate dateEmbauche,
        String cin,
        Long contratId,
        boolean valide
) {
}
