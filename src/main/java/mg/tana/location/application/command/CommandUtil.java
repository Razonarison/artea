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
import mg.tana.location.domain.model.type.ProduitSousCategorie;

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
        Produit produit = new Produit();
        produit.setCategorie(produitCommand.categorie());
        produit.setSousCategorie(ProduitSousCategorie.valueOf(produitCommand.sousCategorie()));
        produit.setItemDescription(produitCommand.itemDescription());
        produit.setPuAchat(produitCommand.puAchat());
        produit.setPuLocation(produitCommand.puLocation());
        produit.setPuCaution(produitCommand.puCaution());
        produit.setLienAchat(produitCommand.lienAchat());

        return produit;
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
