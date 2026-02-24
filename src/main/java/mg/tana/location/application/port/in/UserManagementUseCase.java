package mg.tana.location.application.port.in;

import mg.tana.location.application.command.AssignContratToUserCommand;
import mg.tana.location.application.command.CreateUserCommand;
import mg.tana.location.domain.model.User;

import java.util.List;

public interface UserManagementUseCase {

    User createUser(CreateUserCommand command);

    User findUser(Long userId);

    User assignContratToUser(AssignContratToUserCommand command);

    List<User> listUsers();
}
