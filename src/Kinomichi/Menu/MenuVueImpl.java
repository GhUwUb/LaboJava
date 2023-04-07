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


        System.out.println("---------------------------");
        System.out.println("Quelle option voulez vous ?");
        System.out.println("---------------------------");
        while (iteratorKey.hasNext()){
            Object next = iteratorKey.next();
            System.out.printf("    | %s ", next);
            int length = next.toString().length();
            for(int i = 0; i<11-length; i++){
                System.out.print(" ");
            }
            System.out.println("|");

        }
        String choix = scan.nextLine();



        return choix;
    }
}
