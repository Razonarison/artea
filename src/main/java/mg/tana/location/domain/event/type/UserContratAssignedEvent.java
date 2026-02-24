package mg.tana.location.domain.event.type;

public record UserContratAssignedEvent(
        Long userId,
        Long contratId
) {
}
