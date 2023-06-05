package com.petfinder.pojo;

public class Ville {

    private int idVille;
    private String nomVille;
    private int cpVille;

    public Ville() {}

    public Ville(String nomVille, int cpVille) {
        this.nomVille = nomVille;
        this.cpVille = cpVille;
    }

    @Override
    public String toString() {
        return "Ville{" +
                "idVille=" + idVille +
                ", nomVille='" + nomVille + '\'' +
                ", cpVille=" + cpVille +
                '}';
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public int getCpVille() {
        return cpVille;
    }

    public void setCpVille(int cpVille) {
        this.cpVille = cpVille;
    }
}
