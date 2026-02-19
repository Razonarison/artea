package mg.tana.location.domain.event.type;

import java.time.LocalDate;

public record UserCreatedEvent(
        Long userId,
        String nom,
        String prenom,
        LocalDate dateNaissance,
        String cin,
        Long contratId,
        boolean valide
) {
}
