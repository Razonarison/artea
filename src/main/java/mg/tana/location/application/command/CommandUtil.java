package mg.tana.location.application.command;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import mg.tana.location.application.port.out.ContratRepositoryPort;
import mg.tana.location.application.port.out.UserRepositoryPort;
import mg.tana.location.domain.model.Contrat;
import mg.tana.location.domain.model.Produit;
import mg.tana.location.domain.model.User;

import java.util.Optional;

@ApplicationScoped
public class CommandUtil {

    @Inject
    ContratRepositoryPort contratRepositoryPort;

    @Inject
    UserRepositoryPort userRepositoryPort;

    public User mapUserCommandToEntity(CreateUserCommand userCommand) {
        Contrat contrat = null;
        if (userCommand.contratId() != null) {
            Optional<Contrat> contratOptional = contratRepositoryPort.findById(userCommand.contratId());
            contrat = contratOptional.orElseThrow(() -> new IllegalArgumentException("Contrat introuvable: " + userCommand.contratId()));
        }

        return new User(
                null,
                userCommand.nom(),
                userCommand.prenom(),
                userCommand.dateNaissance(),
                userCommand.dateEmbauche(),
                userCommand.cin(),
                contrat,
                userCommand.valide()
        );
    }

    public Contrat mapContratCommandToEntity(CreateContratCommand contratCommand) {
        Contrat contrat = new Contrat();
        contrat.setType(contratCommand.type());
        contrat.setDebutContrat(contratCommand.debutContrat());
        contrat.setFinContrat(contratCommand.finContrat());
        contrat.setSalaireBase(contratCommand.salaireBase());

        return contrat;
    }

    public Produit mapProduitCommandToEntity(CreateProduitCommand produitCommand) {
        return null;
    }

    public User mapUserAssignementContrat(AssignContratToUserCommand assignContratToUserCommand) {
        Optional<User> user = userRepositoryPort.findById(assignContratToUserCommand.userId());
        if (!user.isPresent()) {
            throw new NotFoundException("Utilisateur " + assignContratToUserCommand.userId() + " introuvable");
        }

        Optional<Contrat> contrat = contratRepositoryPort.findById(assignContratToUserCommand.contratId());
        if (!contrat.isPresent()) {
            throw new NotFoundException("Contrat " + assignContratToUserCommand.contratId() + " introuvable");
        }

        user.get().setContrat(contrat.get());

        return user.get();
    }

}
