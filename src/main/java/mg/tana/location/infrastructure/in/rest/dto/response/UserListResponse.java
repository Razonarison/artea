package mg.tana.location.infrastructure.in.rest.dto.response;

import mg.tana.location.application.service.ChampLibelle;

import java.time.LocalDate;

public class UserListResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String cin;
    @ChampLibelle("Date d'embauche")
    private LocalDate dateEmbauche;

    public UserListResponse(Long id, String nom, String prenom, String cin, LocalDate dateEmbauche) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.dateEmbauche = dateEmbauche;
    }

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

}
