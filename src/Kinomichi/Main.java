package Kinomichi;

import Kinomichi.Menu.*;


public class Main {
    static Controller controller = new Controller();
    public static void main(String[] args) {
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
                menuBuilder.addItem("Modifier", "ModifierInscription", getModifierInscription());
                menuBuilder.addItem("Retour", "RetourPersonne", () -> menuInscriptions.setFinish(true));
            }
            menuBuilder.endMenu();

            Menu menuActivités = menuBuilder.startMenu("Activités", "menuActivités");
                {
                    menuBuilder.addItem("Ajouter", "AjouterActivités", getAjouterActivités());
                    menuBuilder.addItem("Enlever", "EnleverActivités", getEnleverActivités());
                    menuBuilder.addItem("Modifier", "ModifierActivités", getModifierActivités());
                    menuBuilder.addItem("Retour", "RetourPrincipal", () -> menuActivités.setFinish(true));
                }
            menuBuilder.endMenu();
            menuBuilder.addItem("Quitter", "QuitterPrincipal", () -> menuPrincipal.setFinish(true));

        }
        menuBuilder.end();

        while(!menuPrincipal.isFinish())
            menuPrincipal.execute();

    }

    private static Runnable getModifierActivités() {
        return ()-> controller.addInscription();
    }

    private static Runnable getEnleverActivités() {
        return ()-> controller.addInscription();
    }

    private static Runnable getAjouterActivités() {
        return ()-> controller.addInscription();
    }

    private static Runnable getModifierInscription() {
        return ()-> controller.modifyInscription();
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