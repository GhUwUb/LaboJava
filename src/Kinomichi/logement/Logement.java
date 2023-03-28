package Kinomichi.logement;


import Kinomichi.InterfaceActivités;
import Kinomichi.Responsable;

import java.awt.*;
import java.time.LocalDateTime;

public class Logement implements InterfaceActivités {
    @Override
    public int getNbrParticipant() {
        return 0;
    }

    @Override
    public List[] getListParticipant() {
        return new List[0];
    }

    @Override
    public LocalDateTime getHoraire() {
        return null;
    }

    @Override
    public Responsable getResponsable() {
        return null;
    }
}
