package Kinomichi.activités;

import Kinomichi.inscription.Personne;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Activités implements Serializable {
    String nom;
    LocalDateTime début;
    LocalDateTime fin;
    Duration durée;
    List<Personne> list;

    public Activités(String nom, LocalDateTime début, LocalDateTime fin){
        this.nom = nom;
        this.début = début;
        this.durée = Duration.between(début, fin);
        this.fin = fin;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime getDébut() {
        return début;
    }

    public void setDébut(LocalDateTime début) {
        this.début = début;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public String getNom(){
        return nom;
    }

    public List<Personne> getList() {
        return list;
    }
}
