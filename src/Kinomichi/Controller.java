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
    Factory list;
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
        System.out.println("Indiquez le nom de la personne que vous voulez enlever");
        String nom = Console.lireString();
        System.out.println("Indiquez le prénom de la personne que vous voulez enlever");
        String prénom = Console.lireString();
        for(Personne p : listPersonne){
            if(p.getNom().equals(nom))
                if(p.getPrénom().equals(prénom)) {
                    listPersonne.remove(p);
                    break;
                }
        }
        System.out.println("Nous n'avons pas trouvé de personnes correspondant à ce nom et/ou à ce prénom");
    }

    public void modifyPersonne() {
        String temp;
        System.out.println("Indiquez le nom de la personne que vous voulez modifier");
        String nom = Console.lireString();
        System.out.println("Indiquez le prénom de la personne que vous voulez modifier");
        String prénom = Console.lireString();
        for(Personne p : listPersonne){
            if(p.getNom().equals(nom))
                if(p.getPrénom().equals(prénom)) {
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
                    if(temp.equals("Oui"))
                        p.setResp(true);
                    else
                        p.setResp(false);
                    break;
                }
        }
        System.out.println("Nous n'avons pas trouvé de personnes correspondant à ce nom et/ou à ce prénom");
    }

    public void addInscription() {
        boolean continuez = false;
        System.out.println("Indiquez le nom de la personne que vous voulez inscrire");
        String nom = Console.lireString();
        System.out.println("Indiquez le prénom de la personne que vous voulez inscrire");
        String prénom = Console.lireString();

        for (Personne p : listPersonne) {
            if (p.getNom().equals(nom))
                if (p.getPrénom().equals(prénom)) {
                    System.out.printf("Est-ce bien %s %s ? Oui/Non", p.getPrénom(), p.getNom());
                    String choix = Console.lireString();
                    if (choix.equals("Oui"))
                        continuez = true;
                }
            if(continuez)
                System.out.println("Dans quel activité voulez vous l'inscrire ?");
                String activité = Console.lireString();


        }
    }

    public Personne rechercheP (String nom, String prenom) {
        for (Personne p : listPersonne) {
            if (p.getNom().equals(nom) && p.getPrénom().equals(prenom)) {
                System.out.printf("Est-ce bien %s %s ? Oui/Non", p.getPrénom(), p.getNom());
                String choix = Console.lireString();
                if (choix.equalsIgnoreCase("Oui"))
                    return p;
            }
        }
        return null;
    }
}
