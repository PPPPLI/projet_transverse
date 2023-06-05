package com.petfinder.pojo;

public class Localisation {

    private int idLocalisation;
    private String villeLocalisation;
    private int cpLocalisation;
    private String rueLocalisation;

    public Localisation() {
    }

    public Localisation(String villeLocalisation, int cpLocalisation, String rueLocalisation) {
        this.villeLocalisation = villeLocalisation;
        this.cpLocalisation = cpLocalisation;
        this.rueLocalisation = rueLocalisation;
    }

    @Override
    public String toString() {
        return "Localisation{" +
                "idLocalisation=" + idLocalisation +
                ", villeLocalisation='" + villeLocalisation + '\'' +
                ", cpLocalisation=" + cpLocalisation +
                ", rueLocalisation='" + rueLocalisation + '\'' +
                '}';
    }

    public int getIdLocalisation() {
        return idLocalisation;
    }

    public void setIdLocalisation(int idLocalisation) {
        this.idLocalisation = idLocalisation;
    }

    public String getVilleLocalisation() {
        return villeLocalisation;
    }

    public void setVilleLocalisation(String villeLocalisation) {
        this.villeLocalisation = villeLocalisation;
    }

    public int getCpLocalisation() {
        return cpLocalisation;
    }

    public void setCpLocalisation(int cpLocalisation) {
        this.cpLocalisation = cpLocalisation;
    }

    public String getRueLocalisation() {
        return rueLocalisation;
    }

    public void setRueLocalisation(String rueLocalisation) {
        this.rueLocalisation = rueLocalisation;
    }
}
