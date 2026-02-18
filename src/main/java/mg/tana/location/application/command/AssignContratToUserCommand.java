package mg.tana.location.application.command;

import java.util.UUID;

public record AssignContratToUserCommand(
        UUID userId,
        UUID contratId
) {
}
