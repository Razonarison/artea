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

        Optional<User> existing = findById(user.getId());
        if (!existing.isPresent()) {
            user.persist();
            return user;
        }

        existing.get().setNom(user.getNom());
        existing.get().setPrenom(user.getPrenom());
        existing.get().setDateNaissance(user.getDateNaissance());
        existing.get().setDateEmbauche(user.getDateEmbauche());
        existing.get().setCin(user.getCin());
        existing.get().setContrat(user.getContrat());
        existing.get().setValide(user.isValide());

        return existing.get();
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
