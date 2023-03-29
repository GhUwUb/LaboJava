package Kinomichi.Menu;


import javax.swing.*;
import java.util.*;

public class Menu extends Item{
    private Map<String, Item> itemMap = new LinkedHashMap<>();
    private MenuVue vue;
    private boolean finish = false;



    public Menu(String label, MenuVue vue) {
        super(label);
        this.vue = vue;
    }

    public MenuVue getVue() {
        return vue;
    }
    public void setVue(MenuVue vue){
        Objects.requireNonNull(vue);
        this.vue = vue;
    }

    public Item addItem(String key, Item value) {

        return itemMap.put(key, value);
    }

    @Override
    public void execute() {
        String choix = vue.getChoice(this);

        while(!itemMap.containsKey(choix))
            choix = vue.getChoice(this);

        itemMap.get(choix).execute();
    }

    public Map<String, String> getItemText() {
        Map<String, String> map = new LinkedHashMap<>();
        Iterator<String> iterator = itemMap.keySet().iterator();

        while(iterator.hasNext()){
            String next = iterator.next();
            map.put(next, itemMap.get(next).getLabel());
        }
        return map;
    }
    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
