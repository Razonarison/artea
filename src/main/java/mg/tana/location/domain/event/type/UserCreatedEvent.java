package mg.tana.location.domain.event.type;

import java.time.LocalDate;
import java.util.UUID;

public record UserCreatedEvent(
        UUID userId,
        String nom,
        String prenom,
        LocalDate dateNaissance,
        String cin,
        boolean valide
) {
}
