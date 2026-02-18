package mg.tana.location.domain.event.type;

import java.util.UUID;

public record UserContratAssignedEvent(
        UUID userId,
        UUID contratId
) {
}
