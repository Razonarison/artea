package mg.tana.location.infrastructure.in.rest.dto.response;

import mg.tana.location.application.service.ChampLibelle;
import mg.tana.location.application.service.FormatNumber;
import mg.tana.location.domain.model.type.ProduitSousCategorie;

import java.math.BigDecimal;

public class ProduitListResponse {
    private Long id;
    private String categorie;
    @ChampLibelle("Sous catégorie")
    private ProduitSousCategorie sousCategorie;
    @ChampLibelle("Description")
    private String itemDescription;
    @ChampLibelle("PU location")
    @FormatNumber
    private BigDecimal puLocation;
    @ChampLibelle("PU caution")
    @FormatNumber
    private BigDecimal puCaution;

    public ProduitListResponse(Long id, String categorie, ProduitSousCategorie sousCategorie, String itemDescription, BigDecimal puLocation, BigDecimal puCaution) {
        this.id = id;
        this.categorie = categorie;
        this.sousCategorie = sousCategorie;
        this.itemDescription = itemDescription;
        this.puLocation = puLocation;
        this.puCaution = puCaution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public ProduitSousCategorie getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(ProduitSousCategorie sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BigDecimal getPuLocation() {
        return puLocation;
    }

    public void setPuLocation(BigDecimal puLocation) {
        this.puLocation = puLocation;
    }

    public BigDecimal getPuCaution() {
        return puCaution;
    }

    public void setPuCaution(BigDecimal puCaution) {
        this.puCaution = puCaution;
    }
}
