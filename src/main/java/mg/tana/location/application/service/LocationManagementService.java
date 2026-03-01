package mg.tana.location.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
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
import mg.tana.location.domain.event.type.ProduitCreatedEvent;
import mg.tana.location.domain.event.type.UserContratAssignedEvent;
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
        return contratRepositoryPort.findAll();
    }

    @Override
    public Contrat getContrat(Long id) {
        Optional<Contrat> contratOptional = contratRepositoryPort.findById(id);
        if (!contratOptional.isPresent()) {
            throw new NotFoundException("Contrat " + id + " introuvable ");
        }

        return contratOptional.get();
    }

    @Override
    @Transactional
    public Produit createProduit(CreateProduitCommand command) {
        Produit produit = commandUtil.mapProduitCommandToEntity(command);
        produitRepositoryPort.save(produit);

        ProduitCreatedEvent produitCreatedEvent = new ProduitCreatedEvent(
                produit.getId(),
                produit.getCategorie(),
                produit.getSousCategorie().toString(),
                produit.getItemDescription(),
                produit.getPuAchat(),
                produit.getPuLocation(),
                produit.getPuCaution(),
                produit.getLienAchat()
        );

        eventStorePort.append(produitCreatedEvent.getClass().getSimpleName(), produit.getId(), produitCreatedEvent);

        return produit;
    }

    @Override
    public List<Produit> listProduits() {
        return produitRepositoryPort.findAll();
    }

    @Override
    public Produit getProduit(Long id) {
        Optional<Produit> produitOptional = produitRepositoryPort.findById(id);
        if (!produitOptional.isPresent()) {
            throw new NotFoundException("Produit " + id + " introuvable");
        }

        return produitOptional.get();
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
        User user = commandUtil.mapUserAssignementContrat(command);
        userRepositoryPort.save(user);

        UserContratAssignedEvent contratAssignedEvent = new UserContratAssignedEvent(command.userId(), command.contratId());
        eventStorePort.append(contratAssignedEvent.getClass().getSimpleName(), user.getId(), contratAssignedEvent);

        return user;
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
