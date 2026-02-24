package mg.tana.location.domain.event.type;

import java.math.BigDecimal;

public record ProduitCreatedEvent(
        Long produitId,
        String categorie,
        String sousCategorie,
        String itemDescription,
        BigDecimal puAchat,
        BigDecimal puLocation,
        BigDecimal puCaution,
        String lienAchat
) {
}
