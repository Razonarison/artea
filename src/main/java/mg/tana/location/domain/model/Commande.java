package mg.tana.location.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "commande")
public class Commande extends AggregateRoot {
    private String nomclient;
    private String prenomClient;
    private String adresseClient;
    private String cinClient;
    private String numeroClient;
    private LocalDate dateCommande;
    private LocalDate dateEvenement;
    private BigDecimal prixTotal;
    private BigDecimal accompte;
    private BigDecimal resteAPayer;
    private LocalDate echeancePaiement;
    private boolean confirmed;
    private boolean payer;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public Commande() {
        super.setValide(true);
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getCinClient() {
        return cinClient;
    }

    public void setCinClient(String cinClient) {
        this.cinClient = cinClient;
    }

    public String getNumeroClient() {
        return numeroClient;
    }

    public void setNumeroClient(String numeroClient) {
        this.numeroClient = numeroClient;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public LocalDate getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(LocalDate dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public BigDecimal getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(BigDecimal prixTotal) {
        this.prixTotal = prixTotal;
    }

    public BigDecimal getAccompte() {
        return accompte;
    }

    public void setAccompte(BigDecimal accompte) {
        this.accompte = accompte;
    }

    public BigDecimal getResteAPayer() {
        return resteAPayer;
    }

    public void setResteAPayer(BigDecimal resteAPayer) {
        this.resteAPayer = resteAPayer;
    }

    public LocalDate getEcheancePaiement() {
        return echeancePaiement;
    }

    public void setEcheancePaiement(LocalDate echeancePaiement) {
        this.echeancePaiement = echeancePaiement;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isPayer() {
        return payer;
    }

    public void setPayer(boolean payer) {
        this.payer = payer;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
