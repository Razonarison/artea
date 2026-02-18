package mg.tana.location.application.command;

import java.math.BigDecimal;

public record CreateProduitCommand(
        String categorie,
        String sousCategorie,
        String itemDescription,
        BigDecimal puAchat,
        BigDecimal puLocation,
        BigDecimal puCaution,
        String lienAchat
) {
}
