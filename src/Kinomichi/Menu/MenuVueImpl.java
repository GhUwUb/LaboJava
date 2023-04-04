package Kinomichi.Menu;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MenuVueImpl implements MenuVue{
    private Scanner scan = new Scanner(System.in);

    @Override
    public String getChoice(Menu menu) {
        int Index = 0;

        Map<String, String> testMap = menu.getItemText();
        Iterator iteratorKey = testMap.keySet().iterator();

        System.out.println("Quelle option voulez vous ?");
        while (iteratorKey.hasNext()){
            Index++;
            Object next = iteratorKey.next();
            System.out.printf("%d. %s \n", Index, next);

        }
        String choix = scan.nextLine();



        return choix;
    }
}
