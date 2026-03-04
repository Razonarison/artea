package mg.tana.location.application.port.out;

import mg.tana.location.domain.model.User;
import mg.tana.location.infrastructure.in.rest.dto.response.UserDetailResponse;
import mg.tana.location.infrastructure.in.rest.dto.response.UserListResponse;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);

    Optional<User> findById(Long id);

    UserDetailResponse findUserDetails(Long id);

    List<UserListResponse> findAll();
}
