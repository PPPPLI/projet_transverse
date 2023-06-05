package com.petfinder.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utilisateur {

    private int idUtilisateur;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String civilite;
    private String emailUtilisateur;
    private String telUtilisateur;
    private String passwordUtilisateur;
    private boolean accesAdmin;
    @Autowired
    private Localisation localisation;

    public Utilisateur() {}

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String civilite, String emailUtilisateur, String telUtilisateur, String passwordUtilisateur, boolean accesAdmin, Localisation idLocalisation) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.civilite = civilite;
        this.emailUtilisateur = emailUtilisateur;
        this.telUtilisateur = telUtilisateur;
        this.passwordUtilisateur = passwordUtilisateur;
        this.accesAdmin = accesAdmin;
        this.localisation = idLocalisation;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public String getTelUtilisateur() {
        return telUtilisateur;
    }

    public void setTelUtilisateur(String telUtilisateur) {
        this.telUtilisateur = telUtilisateur;
    }

    public String getPasswordUtilisateur() {
        return passwordUtilisateur;
    }

    public void setPasswordUtilisateur(String passwordUtilisateur) {
        this.passwordUtilisateur = passwordUtilisateur;
    }

    public boolean isAccesAdmin() {
        return accesAdmin;
    }

    public void setAccesAdmin(boolean accesAdmin) {
        this.accesAdmin = accesAdmin;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setIdLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateur=" + idUtilisateur +
                ", nomUtilisateur='" + nomUtilisateur + '\'' +
                ", prenomUtilisateur='" + prenomUtilisateur + '\'' +
                ", civilitéUtilisateur='" + civilite + '\'' +
                ", emailUtilisateur='" + emailUtilisateur + '\'' +
                ", telUtilisateur=" + telUtilisateur +
                ", passwordUtilisateur='" + passwordUtilisateur + '\'' +
                ", accesAdmin=" + accesAdmin +
                ", localisation=" + localisation +
                '}';
    }
}
