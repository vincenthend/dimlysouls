
import java.util.*;

/**
 * 
 */
public interface Enemy {

    /**
     * 
     */
    private EnemyEntity enemy;

    /**
     * @return
     */
    public int getHealth();

    /**
     * @return
     */
    public int getAttack();

    /**
     * @return
     */
    public int getDefense();

    /**
     * @return
     */
    public int getSpeed();

    /**
     * @return
     */
    public int getLuck();

    /**
     * @return
     */
    public int getEXP();

}