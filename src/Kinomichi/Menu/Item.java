package Kinomichi.Menu;

public abstract class Item {
    private String label;
    private boolean actif = true;
    public Item(String label){
        if(label == null || label.isBlank() || label.isEmpty())
            throw new IllegalArgumentException("Le libellé est vide");
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public abstract void execute();

}
