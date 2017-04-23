package model.item;

import model.player.Player;

/**
 *
 */
public interface Consumables {


  /**
   * @return
   */
  public int getEffectValue();

  /**
   * @return
   */
  public int getStatAffected();

  /**
   *
   */
  public void use(Player player);
}