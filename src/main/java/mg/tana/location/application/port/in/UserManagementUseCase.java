package mg.tana.location.application.port.in;

import mg.tana.location.application.command.AssignContratToUserCommand;
import mg.tana.location.application.command.CreateUserCommand;
import mg.tana.location.domain.model.User;
import mg.tana.location.infrastructure.in.rest.dto.response.UserDetailResponse;
import mg.tana.location.infrastructure.in.rest.dto.response.UserListResponse;

import java.util.List;

public interface UserManagementUseCase {

    User createUser(CreateUserCommand command);

    UserDetailResponse findUserDetails(Long userId);

    User assignContratToUser(AssignContratToUserCommand command);

    List<UserListResponse> listUsers();
}
