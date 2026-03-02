package mg.tana.location.infrastructure.in.rest.dto.request;

import java.math.BigDecimal;

public record CreateProduitRequest(
        String categorie,
        String sousCategorie,
        String itemDescription,
        BigDecimal puAchat,
        BigDecimal puLocation,
        BigDecimal puCaution,
        String lienAchat
) {
}
