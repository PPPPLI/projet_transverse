package com.petfinder.pojo;

import com.petfinder.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Component
public class Animal {

    private int idAnimal;
    private String nomAnimal;
    private String typeAnimal;
    private String sexeAnimal;
    private String couleurAnimal;
    private Date dateAnimal;
    private String etatAnimal;
    private String photoAnimal;
    private String raceAnimal;
    private String descriptionAnimal;
    @Autowired
    private Utilisateur utilisateur;
    @Autowired
    private Localisation localisation;

    public Animal() {}

    public Animal(String nomAnimal, String typeAnimal, String sexeAnimal, String couleurAnimal, Date dateAnimal, String etatAnimal, String photoAnimal, String raceAnimal, String desciptionAnimal, Utilisateur utilisateur, Localisation localisation) {
        this.nomAnimal = nomAnimal;
        this.typeAnimal = typeAnimal;
        this.sexeAnimal = sexeAnimal;
        this.couleurAnimal = couleurAnimal;
        this.dateAnimal = dateAnimal;
        this.etatAnimal = etatAnimal;
        this.photoAnimal = photoAnimal;
        this.raceAnimal = raceAnimal;
        this.descriptionAnimal = desciptionAnimal;
        this.utilisateur = utilisateur;
        this.localisation = localisation;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNomAnimal() {
        return nomAnimal;
    }

    public void setNomAnimal(String nomAnimal) {
        this.nomAnimal = nomAnimal;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getSexeAnimal() {
        return sexeAnimal;
    }

    public void setSexeAnimal(String sexeAnimal) {
        this.sexeAnimal = sexeAnimal;
    }

    public String getCouleurAnimal() {
        return couleurAnimal;
    }

    public void setCouleurAnimal(String couleurAnimal) {
        this.couleurAnimal = couleurAnimal;
    }

    public Date getDateAnimal() {
        return dateAnimal;
    }

    public void setDateAnimal(Date dateAnimal) {
        this.dateAnimal = dateAnimal;
    }

    public String getEtatAnimal() {
        return etatAnimal;
    }

    public void setEtatAnimal(String etatAnimal) {
        this.etatAnimal = etatAnimal;
    }

    public String getPhotoAnimal() {
        return photoAnimal;
    }

    public void setPhotoAnimal(String photoAnimal) {
        this.photoAnimal = photoAnimal;
    }

    public String getRaceAnimal() {
        return raceAnimal;
    }

    public void setRaceAnimal(String raceAnimal) {
        this.raceAnimal = raceAnimal;
    }

    public String getDescriptionAnimal() {
        return descriptionAnimal;
    }

    public void setDescriptionAnimal(String descriptionAnimal) {
        this.descriptionAnimal = descriptionAnimal;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "idAnimal=" + idAnimal +
                ", nomAnimal='" + nomAnimal + '\'' +
                ", typeAnimal='" + typeAnimal + '\'' +
                ", sexeAnimal='" + sexeAnimal + '\'' +
                ", couleurAnimal='" + couleurAnimal + '\'' +
                ", dateAnimal=" + dateAnimal +
                ", etatAnimal='" + etatAnimal + '\'' +
                ", photoAnimal='" + photoAnimal + '\'' +
                ", raceAnimal='" + raceAnimal + '\'' +
                ", desciptionAnimal='" + descriptionAnimal + '\'' +
                ", utilisateur=" + utilisateur +
                ", localisation=" + localisation +
                '}';
    }


}
