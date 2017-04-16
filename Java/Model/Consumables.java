
import java.util.*;

/**
 * 
 */
public interface Consumables {


    /**
     * @param player
     */
    public void use(Player player);

    /**
     * @return
     */
    public int getEffectValue();

    /**
     * @return
     */
    public int getStatAffected();

}