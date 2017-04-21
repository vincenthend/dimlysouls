package model.item;

import model.player.Player;

/**
 *
 */
public class Potion implements Consumables {

  /**
   *
   */
  private int effectValue;
  /**
   *
   */
  private int statAffected;

  /**
   * Default constructor
   */
  public Potion() {
  }

  /**
   * @param player
   */
  public void use(Player player) {
    // TODO implement here
  }

  /**
   * @return
   */
  public int getEffectValue() {
    // TODO implement here
    return 0;
  }

  /**
   * @return
   */
  public int getStatAffected() {
    // TODO implement here
    return 0;
  }

}