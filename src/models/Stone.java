package models;

/**
 * Created by TriplePi on 14.05.2017.
 */
public class Stone {
    boolean colour;
    public Stone(boolean colour){
        this.colour = colour;
    }

    public boolean getPlayer() {
        return colour;
    }
}
