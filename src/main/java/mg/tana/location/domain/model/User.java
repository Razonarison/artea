package mg.tana.location.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table(name = "users")
public class User extends AggregateRoot {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private LocalDate dateEmbauche;
    private String cin;

    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private Contrat contrat;


    public User() {
    }

    public User(Long id, String nom, String prenom, LocalDate dateNaissance, LocalDate dateEmbauche, String cin, Contrat contrat, boolean valide) {
        super(id, valide);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.cin = cin;
        this.contrat = contrat;
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
}
