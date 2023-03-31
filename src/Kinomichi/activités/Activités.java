package Kinomichi.activités;

import Kinomichi.inscription.MapInscription;
import Kinomichi.inscription.Personne;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class Activités {
    String nom;
    LocalDateTime début;
    LocalDateTime fin;
    Duration durée;

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

    public String getStringDurée() {
        String hours = Integer.toString(durée.toHoursPart());
        String minutes = Integer.toString(durée.toMinutesPart());
        String stringDurée = hours +"H "+ minutes;
        return stringDurée;
    }

    public void setDurée(Duration durée) {
        this.durée = durée;
    }

    public String getNom(){
        return nom;
    }
}
