package mg.tana.location.infrastructure.in.rest.dto.response;

import mg.tana.location.application.service.ChampLibelle;

public class UserDetailResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String cin;
    @ChampLibelle("Date d' embauche")
    private String dateEmbauche;
    @ChampLibelle("Date de naissance")
    private String dateNaissance;
    private ContratListResponse contratListResponse;

    public UserDetailResponse(Long id, String nom, String prenom, String cin, String dateEmbauche, String dateNaissance, ContratListResponse contratListResponse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.dateEmbauche = dateEmbauche;
        this.dateNaissance = dateNaissance;
        this.contratListResponse = contratListResponse;
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

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public ContratListResponse getContratListResponse() {
        return contratListResponse;
    }

    public void setContratListResponse(ContratListResponse contratListResponse) {
        this.contratListResponse = contratListResponse;
    }
}