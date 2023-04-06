package Kinomichi;

import Kinomichi.activités.Activités;
import Kinomichi.inscription.Personne;
import Kinomichi.util.Console;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

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

        System.out.println("Sélectionnez la personne à modifier");
        int cpt = 0;
        System.out.println("0. Annulez");
        for (Personne p : listPersonne) {
            cpt++;
            System.out.printf("%d %s %s %s", cpt, p.getNom(), p.getPrénom(), p.getClub());
        }
        int choix = Console.lireInt() - 1;
        if(choix != 0)
            listPersonne.remove(choix);
    }
    public void modifyPersonne() {

        System.out.println("Sélectionnez la personne à modifier");
        int cpt = 0;
        System.out.println("0. Annulez");
        for(Personne p : listPersonne){
            cpt++;
            System.out.printf("%d %s %s %s", cpt, p.getNom(), p.getPrénom(), p.getClub());
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
        System.out.println("Indiquez le nom");
        String nom = Console.lireString();
        System.out.println("Indiquez la date de début");
        LocalDateTime début = getDate();
        System.out.println("Indiquez la date de fin");
        LocalDateTime fin = getDate();
        Activités a = new Activités(nom, début, fin);
        listActivités.add(a);
    }
    public void removeActivité() {
        System.out.println("Sélectionnez l'activité à enlever");
        int cpt = 0;
        System.out.println("0. Annulez");
        for(Activités a : listActivités) {
            cpt++;
            System.out.printf("%d %s %s %s \n", cpt, a.getNom(), a.getDébut().toString(), a.getFin().toString());
        }
        int choix = Console.lireInt()-1;

        if(choix != 0)
            listActivités.remove(choix);
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

    public void addInscription() {
        System.out.println("Sélectionnez la personne à inscrire");
        int cpt = 0;
        System.out.println("0. Annulez");
        for (Personne p : listPersonne) {
            cpt++;
            System.out.printf("%d %s %s %s", cpt, p.getNom(), p.getPrénom(), p.getClub());
        }
        int choix = Console.lireInt() - 1;
        if(choix != 0)
            Personne p = listPersonne.get(choix);

    }




    public void removeInscription() {

    }
    public void modifyInscription() {
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

    private boolean wantToContinue() {
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

    private boolean wantToInscrire() {
        System.out.println("Voulez vous ajouter cette personne au programme ?");
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
        System.out.println("Indiquez le nom de la personne");
        String nom = Console.lireString();
        System.out.println("Indiquez le prénom de la personne");
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

    public Activités rechercheA(){
        System.out.println("Dans quel activité voulez vous l'inscrire ?");
        String activité = Console.lireString();
        for(Activités a : listActivités){
            if(activité.equalsIgnoreCase(a.getNom())){
                return a;
            }
        }
        System.out.println("Nous n'avons pas trouvé l'activité");
        return null;
    }
    private void addA() {
    }
    private void afficheListA() {
        int cpt =0;
        for(Activités a : listActivités){
            cpt++;
            System.out.printf("%d: %s Début : %s Fin : %s Durée : %s",cpt, a.getNom(), a.getDébut().toString(), a.getFin().toString(), a.getStringDurée() );
        }
    }



}
