package mg.tana.location.application.command;

public record AssignContratToUserCommand(
        Long userId,
        Long contratId
) {
}
