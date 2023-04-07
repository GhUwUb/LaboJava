package Kinomichi;

import Kinomichi.Menu.Menu;
import Kinomichi.Menu.MenuBuilder;
import Kinomichi.activités.*;
import Kinomichi.inscription.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static Kinomichi.Main.controller;

public class Factory implements Serializable {
    ListData list;

    public ListData getList() {
        if (list == null) {
            try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("mesdata.ser"))){
                list = (ListData) input.readObject();
            } catch (FileNotFoundException e) {
                list = new ListData();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public void save() {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream( "mesdatas.ser"))){
            output.writeObject(list);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Factory(){
        MenuBuilder menuBuilder = new MenuBuilder();
        Menu menuPrincipal = menuBuilder.start("Menu Principal");
        {
            Menu menuPersonnes = menuBuilder.startMenu("Personnes", "menuPersonnes");
            {
                menuBuilder.addItem("Ajouter", "AjouterPersonne", getAjouterPersonne());
                menuBuilder.addItem("Enlever", "EnleverPersonne", getEnleverPersonne());
                menuBuilder.addItem("Modifier", "ModifierPersonne", getModifierPersonne());
                menuBuilder.addItem("Retour", "RetourPrincipal", () -> menuPersonnes.setFinish(true));
            }
            menuBuilder.endMenu();

            Menu menuInscriptions = menuBuilder.startMenu("Inscription","menuInscriptions");
            {
                menuBuilder.addItem("Ajouter", "AjouterInscription", getAjouterInscription());
                menuBuilder.addItem("Enlever", "EnleverInscription", getEnleverInscription());
                menuBuilder.addItem("Afficher", "AfficherInscription", getAfficherInscription());
                menuBuilder.addItem("Retour", "RetourPersonne", () -> menuInscriptions.setFinish(true));
            }
            menuBuilder.endMenu();

            Menu menuActivités = menuBuilder.startMenu("Activités", "menuActivités");
            {
                menuBuilder.addItem("Ajouter", "AjouterActivités", getAjouterActivités());
                menuBuilder.addItem("Enlever", "EnleverActivités", getEnleverActivités());
                menuBuilder.addItem("Modifier", "ModifierActivités", getModifierActivités());
                menuBuilder.addItem("Afficher", "AfficherActivité", getAfficherActivité());
                menuBuilder.addItem("Retour", "RetourPrincipal", () -> menuActivités.setFinish(true));
            }
            menuBuilder.endMenu();
            menuBuilder.addItem("Quitter", "QuitterPrincipal", () -> menuPrincipal.setFinish(true));

        }
        menuBuilder.end();

        while(!menuPrincipal.isFinish())
            menuPrincipal.execute();

    }
    public ArrayList<Personne> getListPersonne(){
        ArrayList<Personne> listPersonne = getList().getListP().getListPersonne();
        return  listPersonne;
    }

    public Map<Activités, List<Personne>> getMapInscription(){
        Map<Activités, List<Personne>> mapInscription = getList().getMap().getMap();
        return mapInscription;
    }

    public ArrayList<Activités> getListActivités(){
        ArrayList<Activités> listActivités = getList().getListA().getListActivités();
        return  listActivités;
    }

    private static Runnable getAfficherActivité() { return () -> controller.afficherActivité();
    }
    private static Runnable getAfficherInscription() { return () -> controller.afficherInscription();
    }
    private static Runnable getModifierActivités() {
        return ()-> controller.modifyActivité();
    }

    private static Runnable getEnleverActivités() {
        return ()-> controller.removeActivité();
    }

    private static Runnable getAjouterActivités() {
        return ()-> controller.addActivité();
    }

    private static Runnable getEnleverInscription() {
        return ()-> controller.removeInscription();
    }

    private static Runnable getAjouterInscription() {
        return ()-> controller.addInscription();
    }

    private static Runnable getModifierPersonne() {
        return () -> controller.modifyPersonne();
    }

    private static Runnable getEnleverPersonne() {
        return ()-> controller.removePersonne();
    }

    private static Runnable getAjouterPersonne() {
        return ()-> controller.addPersonne();
    }

}
