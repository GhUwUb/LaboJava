package Kinomichi.inscription;

public class Participants {
    private String nom;
    private String prénom;
    private String club;

    public Participants(String nom, String prénom, String club){
        this.nom = nom;
        this.prénom = prénom;
        this.club = club;
    }
    public Participants(String nom, String prénom){
        this.nom = nom;
        this.prénom = prénom;
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
}
