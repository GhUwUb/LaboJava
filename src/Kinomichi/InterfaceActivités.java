package Kinomichi;

import java.awt.*;
import java.time.LocalDateTime;

public interface InterfaceActivités {
        int getNbrParticipant();
        List[] getListParticipant();
        LocalDateTime getHoraire();
        Responsable getResponsable();
}
