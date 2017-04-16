
import java.util.*;

/**
 * 
 */
public abstract class Player {

    /**
     * Default constructor
     */
    public Player() {
    }

    /**
     * 
     */
    private int health;

    /**
     * 
     */
    private int attack;

    /**
     * 
     */
    private int defense;

    /**
     * 
     */
    private int level;

    /**
     * 
     */
    private int exp;

    /**
     * 
     */
    private int next;

    /**
     * 
     */
    private String nama;

    /**
     * 
     */
    private int classId;

    /**
     * 
     */
    private Game  player;


    /**
     * Menambah level player dan mengurangi nilai exp dengan nilai next.
     * Mengubah nilai next sesuai dengan rumus level^2 + offset
     */
    public void levelUp() {
        // TODO implement here
    }

    /**
     * Mengecek apakah player harus level up
     * @return
     */
    public boolean isLeveling() {
        // TODO implement here
        return false;
    }

}