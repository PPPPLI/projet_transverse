package com.petfinder.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Demande {

    private int idDemande;
    private String etatDemande;
    private Date dateCreationDemande;
    private Date dateRealisationDemande;

    @Autowired
    private Utilisateur utilisateur;
    @Autowired
    private Animal animal;

    public Demande() {}

    public Demande(String etatDemande, Date dateCreationDemande, Date dateRealisationDemande, Utilisateur utilisateur, Animal animal) {
        this.etatDemande = etatDemande;
        this.dateCreationDemande = dateCreationDemande;
        this.dateRealisationDemande = dateRealisationDemande;
        this.utilisateur = utilisateur;
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Demande{" +
                "idDemande=" + idDemande +
                ", etatDemande='" + etatDemande + '\'' +
                ", dateCreationDemande=" + dateCreationDemande +
                ", dateRealisationDemande=" + dateRealisationDemande +
                ", utilisateur=" + utilisateur +
                ", animal=" + animal +
                '}';
    }

    public int getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    public String getEtatDemande() {
        return etatDemande;
    }

    public void setEtatDemande(String etatDemande) {
        this.etatDemande = etatDemande;
    }

    public Date getDateCreationDemande() {
        return dateCreationDemande;
    }

    public void setDateCreationDemande(Date dateCreationDemande) {
        this.dateCreationDemande = dateCreationDemande;
    }

    public Date getDateRealisationDemande() {
        return dateRealisationDemande;
    }

    public void setDateRealisationDemande(Date dateRealisationDemande) {
        this.dateRealisationDemande = dateRealisationDemande;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
