package Kinomichi.Menu;

import java.util.ArrayDeque;
import java.util.Deque;

public class MenuBuilder {
    private MenuVue defaultVue = new MenuVueImpl();
    private Deque<Menu> pileMenu = new ArrayDeque<>();
    public MenuBuilder() {

    }
    public ItemExecutable addItem(String key, String label, Runnable runnable) {
        ItemExecutable item = new ItemExecutable(label, runnable);
        pileMenu.peek().addItem(key, item);
        return item;
    }
    public Menu startMenu(String key, String label, MenuVue vue) {
        Menu menu = new Menu(label, vue);
        pileMenu.peek().addItem(key, menu);
        pileMenu.push(menu);
        return menu;
    }
    public Menu startMenu(String key, String label) {
        return startMenu(key, label, defaultVue);
    }
    public Menu endMenu() {
        return pileMenu.pop();
    }
    public Menu getMenu() {
        return pileMenu.peek();
    }


    public Menu start(String nom) {
        Menu menu = new Menu(nom, defaultVue);
        pileMenu.push(menu);
        return menu;
    }

    public void end() {
        pileMenu.clear();
    }
}
