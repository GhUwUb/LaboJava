package Kinomichi.inscription;

import Kinomichi.activités.Activités;

import java.io.Serializable;
import java.util.*;

public class MapInscription implements Serializable {
    private LinkedHashMap map;
    public MapInscription(){
        this.map = new LinkedHashMap<Activités, List<Personne>>();
    }

    public void addParticipants(Activités a){
        map.put(a,a.getList());
    }
    public void removeParticipants(Personne p){
        map.remove(p);
    }

    public void affichePersonneMap(){
       Set<Personne> personnes = map.keySet();
       for (Personne p: personnes) {
           String activités = map.get(p).toString();
           System.out.println(p.getNom()+ " " + p.getPrénom()+ " Club : " + p.getClub() + "inscrit à l'activité" + activités );
       }
    }

    public LinkedHashMap getMap() {
        return map;
    }
}
