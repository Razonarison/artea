package mg.tana.location.infrastructure.in.rest.dto.response;

import mg.tana.location.application.service.ChampLibelle;
import mg.tana.location.application.service.FormatNumber;
import mg.tana.location.domain.model.type.ContratType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UserDetailResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String cin;
    @ChampLibelle("Date d' embauche")
    private LocalDate dateEmbauche;
    @ChampLibelle("Date de naissance")
    private LocalDate dateNaissance;
    private ContratType typeContrat;
    @FormatNumber
    @ChampLibelle("Salaire de base")
    private BigDecimal salaireBase;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public ContratType getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(ContratType typeContrat) {
        this.typeContrat = typeContrat;
    }

    public BigDecimal getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(BigDecimal salaireBase) {
        this.salaireBase = salaireBase;
    }

    public UserDetailResponse(Long id, String nom, String prenom, String cin, LocalDate dateEmbauche, LocalDate dateNaissance, ContratType typeContrat, BigDecimal salaireBase) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.dateEmbauche = dateEmbauche;
        this.dateNaissance = dateNaissance;
        this.typeContrat = typeContrat;
        this.salaireBase = salaireBase;
    }
}