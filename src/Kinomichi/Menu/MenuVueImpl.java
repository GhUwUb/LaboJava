package Kinomichi.Menu;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MenuVueImpl implements MenuVue{
    private Scanner scan = new Scanner(System.in);

    @Override
    public String getChoice(Menu menu) {

        Map<String, String> testMap = menu.getItemText();

        System.out.println("Quelle option voulez vous ?");
        String choix = scan.nextLine();



        return choix;
    }
}
