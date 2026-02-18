package mg.tana.location.domain.event.type;

import java.math.BigDecimal;
import java.util.UUID;

public record ProduitCreatedEvent(
        UUID produitId,
        String categorie,
        String sousCategorie,
        String itemDescription,
        BigDecimal puAchat,
        BigDecimal puLocation,
        BigDecimal puCaution,
        String lienAchat
) {
}
