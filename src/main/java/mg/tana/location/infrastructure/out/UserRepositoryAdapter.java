package mg.tana.location.infrastructure.out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import mg.tana.location.application.port.out.UserRepositoryPort;
import mg.tana.location.domain.model.User;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserRepositoryAdapter implements UserRepositoryPort {

    @Override
    @Transactional
    public User save(User user) {
        if (user.getId() == null) {
            user.persist();
            return user;
        }

        User existing = User.findById(user.getId());
        if (existing == null) {
            user.persist();
            return user;
        }

        existing.setNom(user.getNom());
        existing.setPrenom(user.getPrenom());
        existing.setDateNaissance(user.getDateNaissance());
        existing.setCin(user.getCin());
        existing.setContrat(user.getContrat());
        existing.setValide(user.isValide());

        return existing;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(User.findById(id));
    }

    @Override
    public List<User> findAll() {
        return User.listAll();
    }
}
