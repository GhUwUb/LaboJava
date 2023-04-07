package Kinomichi.inscription;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListPersonne implements Serializable {
    private ArrayList<Personne> listPersonne = new ArrayList<>();

    public void addListPersonne(Personne p){
        listPersonne.add(p);
    }
    public void removeListPersonne(Personne p){
        listPersonne.remove(p);
    }

    public ArrayList<Personne> getListPersonne(){
        return listPersonne;
    }

}
