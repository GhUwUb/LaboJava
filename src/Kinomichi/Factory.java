package Kinomichi;

import Kinomichi.activités.*;
import Kinomichi.inscription.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Factory {
    ListPersonne listP = new ListPersonne();
    MapInscription map = new MapInscription();
    ListActivités listA = new ListActivités();
    public Factory(){
    }
    public ArrayList<Personne> getListPersonne(){
        ArrayList<Personne> listPersonne = listP.getListPersonne();
        return  listPersonne;
    }

    public Map<Personne, Activités> getMapInscription(){
        Map<Personne, Activités> mapInscription = map.getMap();
        return mapInscription;
    }

    public ArrayList<Activités> getListActivités(){
        ArrayList<Activités> listActivités = listA.getListActivités();
        return  listActivités;
    }
}
