package Kinomichi.activités;

import java.io.Serializable;
import java.util.ArrayList;

public class ListActivités implements Serializable {
    private ArrayList<Activités> listActivités= new ArrayList<>();

    public ArrayList<Activités> getListActivités(){
        return listActivités;
    }

}