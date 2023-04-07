package Kinomichi;

import Kinomichi.activités.ListActivités;
import Kinomichi.inscription.ListPersonne;
import Kinomichi.inscription.MapInscription;

import java.io.Serializable;

public class ListData implements Serializable {

   ListPersonne listP;
   ListActivités listA;
   MapInscription map;


    public ListData() {
        listP = new ListPersonne();
        listA = new ListActivités();
        map = new MapInscription();
    }

    public ListPersonne getListP() {
        return listP;
    }

    public MapInscription getMap() {
        return map;
    }

    public ListActivités getListA() {
        return listA;
    }
}
