package Kinomichi;

import Kinomichi.activités.Activités;
import Kinomichi.inscription.Personne;
import Kinomichi.util.Console;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Controller implements Serializable {
    public Factory list = new Factory();
    ArrayList<Personne> listPersonne;
    Map<Activités, List<Personne>> mapInscription;
    ArrayList<Activités> listActivités;
    public Controller(){
        this.listPersonne = list.getList().getListP().getListPersonne();
        this.mapInscription = list.getList().getMap().getMap();
        this.listActivités = list.getList().getListA().getListActivités();
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
        Iterator iterator= mapInscription.keySet().iterator();

        System.out.println("Sélectionnez la personne à modifier");
        int cpt = 0;
        System.out.println("0. Annulez");
        for (Personne p : listPersonne) {
            cpt++;
            System.out.printf("%d %s %s %s", cpt, p.getNom(), p.getPrénom(), p.getClub());
        }
        int choix = Console.lireInt() - 1;
        if(choix != -1) {
            while(iterator.hasNext()){
                mapInscription.get(iterator.next()).remove(listPersonne.get(choix));
            }
            listPersonne.remove(choix);

        }
    }
    public void modifyPersonne() {

        System.out.println("Sélectionnez la personne à modifier");
        System.out.println("0. Annulez");
        for(Personne p : listPersonne){
            System.out.printf("%d %s %s %s", listPersonne.indexOf(p), p.getNom(), p.getPrénom(), p.getClub());
        }
        int choix = Console.lireInt()-1;
        Personne p = listPersonne.get(choix);
        System.out.println("Que voulez vous modifier ?");
        System.out.printf("1. Nom | %s", p.getNom());
        System.out.printf("2. Prénom | %s", p.getPrénom());
        System.out.printf("3. Club | %s", p.getClub());
        choix = Console.lireInt();

        switch (choix){
            case 1 -> {
                System.out.println("Ecrivez le nouveau nom");
                String nom = Console.lireString();
                p.setNom(nom);
            }
            case 2 -> {
                System.out.println("Ecrivez le nouveau prénom");
                String prenom = Console.lireString();
                p.setPrénom(prenom);
            }
            case 3 -> {
                System.out.println("Ecrivez le nouveau club");
                String club = Console.lireString();
                p.setNom(club);
            }
        }
    }
    public void addActivité() {
        System.out.println("Nom :");
        String nom = Console.lireString();
        System.out.println("Date début");
        LocalDateTime début = getDate();
        System.out.println("Date fin");
        LocalDateTime fin = getDate();
        Activités a = new Activités(nom, début, fin);
        listActivités.add(a);
    }
    public void removeActivité() {
        Activités aFinal;
        System.out.println("Sélectionnez l'activité à enlever");
        System.out.println("0. Annulez");
        for(Activités a : listActivités) {
            System.out.printf("%d %s %s %s \n", listActivités.indexOf(a), a.getNom(), a.getDébut().toString(), a.getFin().toString());
        }
        int choix = Console.lireInt()-1;

        if(choix != -1) {
            mapInscription.remove(listActivités.get(choix));
            listActivités.remove(choix);
        }
    }
    public void modifyActivité() {
        System.out.println("Sélectionnez l'activité à modifier");
        int cpt = 0;
        System.out.println("0. Annulez");
        for(Activités a : listActivités) {
            cpt++;
            System.out.printf("%d %s %s %s \n", cpt, a.getNom(), a.getDébut().toString(), a.getFin().toString());
        }
        int choix = Console.lireInt()-1;
        Activités a = listActivités.get(choix);
        System.out.println("Que voulez vous modifier ?");
        System.out.printf("1. Nom | %s", a.getNom());
        System.out.printf("2. Début | %s", a.getDébut());
        System.out.printf("3. Fin | %s", a.getFin());
        choix = Console.lireInt();

        switch (choix){
            case 1 -> {
                System.out.println("Ecrivez le nouveau nom");
                String nom = Console.lireString();
                a.setNom(nom);
            }
            case 2 -> {
                System.out.println("Ecrivez la nouvelle heure de début");
                a.setDébut(getDate());
            }
            case 3 -> {
                System.out.println("Ecrivez la nouvele heure de fin");
                a.setFin(getDate());
            }
        }
    }
    public void afficherActivité(){
        System.out.println("Voici la liste des activités");
        for(Activités a : listActivités){
            System.out.printf("%d %s %s %s", listActivités.indexOf(a), a.getNom(), a.getDébut().toString(), a.getFin().toString());
        }
    }
    public void addInscription() {
        Personne pFinal;
        Activités aFinal;
        System.out.println("Sélectionnez la personne à inscrire");
        int cpt = 0;
        System.out.println("0. Annulez");
        for (Personne p : listPersonne) {
            cpt++;
            System.out.printf("%d. %s %s %s\n", cpt, p.getNom(), p.getPrénom(), p.getClub());
        }
        int choix = Console.lireInt() - 1;
        if(choix != -1) {
            pFinal = listPersonne.get(choix);
            System.out.printf("Vous avez sélectionné %s %s\n", pFinal.getPrénom(), pFinal.getNom());
        }
        else
            return;

        System.out.println("Sélectionnez l'activité dans laquel vous voulez l'inscrire");
        cpt = 0;
        System.out.println("0. Annulez");
        for(Activités a : listActivités) {
            cpt++;
            System.out.printf("%d. %s %s %s \n", cpt, a.getNom(), a.getDébut().toString(), a.getFin().toString());
        }
        choix = Console.lireInt() - 1;
        if(choix != -1) {
            aFinal = listActivités.get(choix);
            System.out.printf("Vous avez sélectionné %s\n", aFinal.getNom());
        }
        else
            return;

        if(mapInscription.isEmpty() || !mapInscription.keySet().contains(aFinal)){
            mapInscription.put(aFinal, aFinal.getList());
            mapInscription.get(aFinal).add(pFinal);
        }else
            mapInscription.get(aFinal).add(pFinal);

    }
    public void removeInscription() {
        Iterator iterator = mapInscription.keySet().iterator();
        ArrayList<Integer> listIndex = new ArrayList<Integer>();
        System.out.println("Sélectionnez la personne à désinscrire");
        System.out.println("0. Annulez");
        for (Personne p : listPersonne) {
            System.out.printf("%d %s %s %s", listPersonne.indexOf(p), p.getNom(), p.getPrénom(), p.getClub());
        }
        int choixP = Console.lireInt() - 1;
        if(choixP != 0) {
            int cpt =0;
            System.out.println("Sélectionnez l'activité dans laquelle vous voulez désinscrire la personne");
            System.out.println("0. Annulez");
            while(iterator.hasNext()){
                cpt++;
                Activités next = (Activités)iterator.next();
                if(mapInscription.get(next).contains(listPersonne.get(choixP))){
                    listIndex.add(cpt);
                    System.out.printf("%d %s %s %s", listIndex.indexOf(cpt), next.getNom(), next.getDébut().toString(), next.getFin().toString());
                }
                int choixA = Console.lireInt()-1;
                if(choixA !=0){
                    mapInscription.get(listActivités.get(listIndex.get(choixA))).remove(choixP);
                }else
                    return;
            }
        }
    }
    public void afficherInscription() {
        Activités aFinal;
        System.out.println("Sélectionnez l'activité à afficher");
        int cpt = 0;
        System.out.println("0. Annulez");
        for(Activités a : listActivités) {
            cpt++;
            System.out.printf("%d %s %s %s \n", cpt, a.getNom(), a.getDébut().toString(), a.getFin().toString());
        }
        int choix = Console.lireInt()-1;
        aFinal = listActivités.get(choix);
        System.out.printf("Voici la liste des pariticipants de %s", aFinal.getNom());
        for(Personne p : aFinal.getList()){
            System.out.printf("%d %s %s %s", listPersonne.indexOf(p), p.getNom(), p.getPrénom(), p.getClub());
        }
    }

    private static LocalDateTime getDate() {
        // variables
        LocalDateTime date;
        String input;
        String[] tab;
        // tant que le nombre de valeur entré est diff de celle attendu alors on execute la boucle
        do {
            //affichage demande + lecture input user
            System.out.println("Annee.Mois.Jour.Heure.Minute");
            input = Console.lireString();
            tab = input.split("\\.");
        } while (tab.length < 5);
        // création de la date à partie des saisies
        date = LocalDateTime.of(
                Integer.valueOf(tab[0]),
                Integer.valueOf(tab[1]),
                Integer.valueOf(tab[2]),
                Integer.valueOf(tab[3]),
                Integer.valueOf(tab[4]));
        // retourne la date
        return date;
    }


}
