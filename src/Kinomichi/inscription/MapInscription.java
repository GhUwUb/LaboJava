package Kinomichi.inscription;

import Kinomichi.activités.Activités;

import java.util.*;

public class MapInscription {
    private LinkedHashMap map;
    public MapInscription(){
        this.map = new LinkedHashMap<Personne, List<Activités>>();
    }

    public void addParticipants(Personne p, List<Activités> ListA){
        map.put(p,p.getList());
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
