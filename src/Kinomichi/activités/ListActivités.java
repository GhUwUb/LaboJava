package Kinomichi.activités;

import Kinomichi.inscription.Personne;

import java.util.ArrayList;

public class ListActivités {
    private ArrayList<Activités> listActivités= new ArrayList<>();

    public void addListActivités(Activités a){
        listActivités.add(a);
    }
    public void removeListActivités(Activités a){
        listActivités.remove(a);
    }

    public ArrayList<Activités> getListActivités(){
        return listActivités;
    }

}