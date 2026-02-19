package mg.tana.location.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import mg.tana.location.domain.model.type.ProduitSousCategorie;
import java.math.BigDecimal;

@Entity
@Table(name = "produit")
public class Produit extends AggregateRoot {
    private String categorie;

    @Enumerated(EnumType.STRING)
    private ProduitSousCategorie sousCategorie;
    private String itemDescription;
    private BigDecimal puAchat;
    private BigDecimal puLocation;
    private BigDecimal puCaution;
    private String lienAchat;

    public Produit() {
    }

    public Produit(Long id, String categorie, ProduitSousCategorie sousCategorie, String itemDescription, BigDecimal puAchat,
                   BigDecimal puLocation, BigDecimal puCaution, String lienAchat) {
        super(id);
        this.categorie = categorie;
        this.sousCategorie = sousCategorie;
        this.itemDescription = itemDescription;
        this.puAchat = puAchat;
        this.puLocation = puLocation;
        this.puCaution = puCaution;
        this.lienAchat = lienAchat;
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

    public BigDecimal getPuAchat() {
        return puAchat;
    }

    public void setPuAchat(BigDecimal puAchat) {
        this.puAchat = puAchat;
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

    public String getLienAchat() {
        return lienAchat;
    }

    public void setLienAchat(String lienAchat) {
        this.lienAchat = lienAchat;
    }
}
