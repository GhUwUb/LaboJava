package Kinomichi;

import Kinomichi.activités.Activités;
import Kinomichi.inscription.ListPersonne;
import Kinomichi.inscription.Personne;
import Kinomichi.util.Console;
import Kinomichi.Factory;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    Factory list = new Factory();
    ArrayList<Personne> listPersonne;
    Map<Personne, Activités> mapInscription;
    ArrayList<Activités> listActivités;
    public Controller(){
        this.listPersonne = list.getListPersonne();
        this.mapInscription = list.getMapInscription();
        this.listActivités = list.getListActivités();
    }

    public void addPersonne(){

        boolean resp = false;
        String club = "Club inconnu";

        System.out.println("Nom :");
        String nom = Console.lireString();
        
        System.out.println("Prénom :");
        String prenom = Console.lireString();
        
        System.out.println("Responsable ? Oui/Non");
        String choixResp = Console.lireString();
        if(choixResp.equals("Oui"))
            resp = true;

        System.out.println("Ajoutez un club ? Oui/Non");
        String choix = Console.lireString();
        if(choix.equals("Oui")) {
            System.out.println("Nom du club :");
            club = Console.lireString();
        }
        Personne p = new Personne(nom, prenom, club, resp);
        listPersonne.add(p);
    }

    public void removePersonne() {
        boolean continuez = false;

        while (!continuez) {
            Personne p = rechercheP();

            if (p == null) {
                System.out.println("Nous n'avons pas trouvé de personne correspondant à ce nom");
            } else {
                continuez = confirmerP(p);
                if(continuez)
                    listPersonne.remove(p);
            }
        }
    }

    public void modifyPersonne() {
        String temp;
        boolean continuez = false;

        while (!continuez) {
            Personne p = rechercheP();
            if (p != null) {
                if(confirmerP(p)) {
                    System.out.println("Indiquez le nouveau nom");
                    temp = Console.lireString();
                    p.setNom(temp);
                    System.out.println("Indiquez le nouveau prénom");
                    temp = Console.lireString();
                    p.setPrénom(temp);
                    System.out.println("Indiquez le nouveau club");
                    temp = Console.lireString();
                    p.setClub(temp);
                    System.out.println("Est-il responsable ? Oui/Non");
                    temp = Console.lireString();
                    if (temp.equals("Oui"))
                        p.setResp(true);
                    else
                        p.setResp(false);
                }else{
                    continuez = wantToContinue();
                }
            } else {
                System.out.println("Nous n'avons pas trouvé de personnes correspondant à ce nom et/ou à ce prénom");
                continuez = wantToContinue();
            }
        }
    }

    public void addInscription() {
        boolean continuez = true;
        Personne p;
        while (continuez){
            p = rechercheP();

            if (p != null) {
                continuez = confirmerP(p);

                if(continuez = false)
                    continuez = wantToContinue();
                else {
                    afficheA();
                }
            }else{
                System.out.println("La personne n'existe pas");
                continuez = wantToContinue();
            }
        }
    }



    public void removeInscription() {

    }
    public void modifyInscription() {
    }

    private boolean wantToContinue() {
        System.out.println("Voulez vous réessayer ?");
        System.out.println("Oui | Non");
        while(true) {
            String choix = Console.lireString();

            if (choix.equalsIgnoreCase("Oui"))
                return true;
            else if(choix.equalsIgnoreCase("Non"))
                return false;
            else
                System.out.println("Vous devez répondre Oui ou Non");
        }
    }

    public Personne rechercheP () {
        System.out.println("Indiquez le nom de la personne que vous voulez enlever");
        String nom = Console.lireString();
        System.out.println("Indiquez le prénom de la personne que vous voulez enlever");
        String prenom = Console.lireString();

        for (Personne p : listPersonne) {
            if (p.getNom().equals(nom) && p.getPrénom().equals(prenom)) {
                    return p;
            }
        }
        return null;
    }

    public boolean confirmerP (Personne p) {
            System.out.printf("Est-ce bien %s %s ? Oui/Non", p.getPrénom(), p.getNom());
            String choix = Console.lireString();
            if (choix.equals("Oui"))
                return true;

            return false;
    }

    public Activités rechercheA(Personne p){
        System.out.println("Dans quel activité voulez vous l'inscrire ?");
        String activité = Console.lireString();
        for(Activités a : p.getList()){
            if(activité.equalsIgnoreCase(a.getNom())){
                return a;
            }
        }
        return null;
    }
    private void afficheA() {
        int cpt =0;
        for(Activités a : listActivités){
            cpt++;
            System.out.printf("%d: %s Début : %s Fin : %s Durée : %s",cpt, a.getNom(), a.getDébut().toString(), a.getFin().toString(), a.getStringDurée() );
        }
    }


}
