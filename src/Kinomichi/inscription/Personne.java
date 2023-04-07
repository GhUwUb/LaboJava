package Kinomichi.inscription;

import Kinomichi.activités.Activités;

import java.io.Serializable;
import java.util.List;

public class Personne implements Serializable {
    private String nom;
    private String prénom;
    private String club;
    private boolean resp;

    public Personne(String nom, String prénom, String club, boolean resp){
        this.nom = nom;
        this.prénom = prénom;
        this.club = club;
        this.resp = resp;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isResp() {
        return resp;
    }

    public void setResp(boolean resp) {
        this.resp = resp;
    }

}
