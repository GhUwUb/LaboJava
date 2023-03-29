package Kinomichi.activités;

import Kinomichi.inscription.MapInscription;
import Kinomichi.inscription.Personne;

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
    Long durée;
    public Activités(String nom, LocalDateTime début, Long durée){
        this.nom = nom;
        this.début = début;
        this.durée = durée;
        this.fin = début.plus(durée, ChronoUnit.MINUTES);
    }

    public String getNom(){
        return nom;
    }
}
