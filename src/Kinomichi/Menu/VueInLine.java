package Kinomichi.Menu;

import java.util.stream.Collectors;
import java.util.Scanner;

public class VueInLine implements MenuVue{
    Scanner scan = new Scanner(System.in);

    @Override
    public String getChoice(Menu menu){
        System.out.print(
                menu.getItemText()
                        .entrySet()
                        .stream()
                        .map(e-> e.getKey() + ": "+e.getValue())
                        .collect(Collectors.joining(" | ","(",") choix: "))
        );
        return scan.nextLine();
    }
}
