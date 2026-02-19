package mg.tana.location.application.service;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mg.tana.location.application.command.*;
import mg.tana.location.application.port.in.ContratManagementUseCase;
import mg.tana.location.application.port.in.EventQueryUseCase;
import mg.tana.location.application.port.in.ProduitManagementUseCase;
import mg.tana.location.application.port.in.UserManagementUseCase;
import mg.tana.location.application.port.out.ContratRepositoryPort;
import mg.tana.location.application.port.out.EventStorePort;
import mg.tana.location.application.port.out.ProduitRepositoryPort;
import mg.tana.location.application.port.out.UserRepositoryPort;
import mg.tana.location.domain.event.EventEntity;
import mg.tana.location.domain.event.type.ContratCreatedEvent;
import mg.tana.location.domain.event.type.UserCreatedEvent;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.domain.model.Produit;
import mg.tana.location.domain.model.User;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class LocationManagementService implements UserManagementUseCase, ContratManagementUseCase, ProduitManagementUseCase, EventQueryUseCase {

    @Inject
    UserRepositoryPort userRepositoryPort;

    @Inject
    ContratRepositoryPort contratRepositoryPort;

    @Inject
    ProduitRepositoryPort produitRepositoryPort;

    @Inject
    EventStorePort eventStorePort;

    @Inject
    CommandUtil commandUtil;

    @Override
    public Contrat createContrat(CreateContratCommand command) {
        Contrat contrat = commandUtil.mapContratCommandToEntity(command);
        contratRepositoryPort.save(contrat);

        ContratCreatedEvent contratCreatedEvent = new ContratCreatedEvent(
            contrat.getId(),
            contrat.getType(),
            contrat.getDebutContrat(),
            contrat.getFinContrat(),
            contrat.getSalaireBase(),
            contrat.isValide()
        );

        eventStorePort.append(contratCreatedEvent.getClass().getSimpleName(), contrat.getId(), contratCreatedEvent);

        return contrat;
    }

    @Override
    public List<Contrat> listContrats() {
        return List.of();
    }

    @Override
    public Produit createProduit(CreateProduitCommand command) {
        return null;
    }

    @Override
    public List<Produit> listProduits() {
        return List.of();
    }

    @Override
    @Transactional
    public User createUser(CreateUserCommand command) {
        User user = commandUtil.mapUserCommandToEntity(command);
        userRepositoryPort.save(user);

        UserCreatedEvent userCreatedEvent = new UserCreatedEvent(
                user.getId(),
                user.getNom(),
                user.getPrenom(),
                user.getDateNaissance(),
                user.getDateEmbauche(),
                user.getCin(),
                user.getContrat() != null ? user.getContrat().getId() : null,
                user.isValide()
        );

        eventStorePort.append(userCreatedEvent.getClass().getSimpleName(), user.getId(), userCreatedEvent);

        return user;
    }

    @Override
    public User findUser(Long userId) {
        Optional<User> user = userRepositoryPort.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }

    @Override
    public User assignContratToUser(AssignContratToUserCommand command) {
        return null;
    }

    @Override
    public List<User> listUsers() {
        return userRepositoryPort.findAll();
    }

    @Override
    public List<EventEntity> listEvents() {
        return eventStorePort.readAll();
    }

}
