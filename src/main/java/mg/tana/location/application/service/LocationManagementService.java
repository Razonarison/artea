package mg.tana.location.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import mg.tana.location.application.command.AssignContratToUserCommand;
import mg.tana.location.application.command.CreateContratCommand;
import mg.tana.location.application.command.CreateProduitCommand;
import mg.tana.location.application.command.CreateUserCommand;
import mg.tana.location.application.port.in.ContratManagementUseCase;
import mg.tana.location.application.port.in.ProduitManagementUseCase;
import mg.tana.location.application.port.in.UserManagementUseCase;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.domain.model.Produit;
import mg.tana.location.domain.model.User;
import java.util.List;

@ApplicationScoped
public class LocationManagementService implements UserManagementUseCase, ContratManagementUseCase, ProduitManagementUseCase {


    @Override
    public Contrat createContrat(CreateContratCommand command) {
        return null;
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
    public User createUser(CreateUserCommand command) {
        return null;
    }

    @Override
    public User assignContratToUser(AssignContratToUserCommand command) {
        return null;
    }

    @Override
    public List<User> listUsers() {
        return List.of();
    }
}
