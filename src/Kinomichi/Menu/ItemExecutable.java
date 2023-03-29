package Kinomichi.Menu;

public class ItemExecutable extends Item{
    private Runnable action;

    public ItemExecutable(String label, Runnable action) {
        super(label);
        this.action = action;
    }

    @Override
    public void execute() {
        if(isActif())
            this.action.run();
    }
}
