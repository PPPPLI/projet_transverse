package com.petfinder.pojo;

import org.springframework.stereotype.Component;

public class Feedback {

    private int idFeedback;
    private String nomUtilisateur;
    private String mailUtilisateur;
    private int telUtilisateur;
    private String desciptionFeedback;

    public Feedback() {}

    public Feedback(String nomUtilisateur, String mailUtilisateur, int telUtilisateur, String desciptionFeedback) {
        this.nomUtilisateur = nomUtilisateur;
        this.mailUtilisateur = mailUtilisateur;
        this.telUtilisateur = telUtilisateur;
        this.desciptionFeedback = desciptionFeedback;
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMailUtilisateur() {
        return mailUtilisateur;
    }

    public void setMailUtilisateur(String mailUtilisateur) {
        this.mailUtilisateur = mailUtilisateur;
    }

    public int getTelUtilisateur() {
        return telUtilisateur;
    }

    public void setTelUtilisateur(int telUtilisateur) {
        this.telUtilisateur = telUtilisateur;
    }

    public String getDesciptionFeedback() {
        return desciptionFeedback;
    }

    public void setDesciptionFeedback(String desciptionFeedback) {
        this.desciptionFeedback = desciptionFeedback;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "idFeedback=" + idFeedback +
                ", nomUtilisateur='" + nomUtilisateur + '\'' +
                ", mailUtilisateur='" + mailUtilisateur + '\'' +
                ", telUtilisateur='" + telUtilisateur + '\'' +
                ", desciptionFeedback='" + desciptionFeedback + '\'' +
                '}';
    }
}
