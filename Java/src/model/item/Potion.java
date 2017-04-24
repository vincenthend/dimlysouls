package model.item;

import model.player.Player;

/**
 * Kelas potion, implemen consumables
 */
public class Potion implements Consumables {
  private int effectValue;
  private int statAffected;

  /**
   * Konstruktor kelas potion
   */
  public Potion() {
  }

  /**
   * Menggunakan potion
   * @param player player yang terkena efek
   */
  public void use(Player player) {
    // TODO implement here
  }

  public int getEffectValue() {
    // TODO implement here
    return 0;
  }

  public int getStatAffected() {
    // TODO implement here
    return 0;
  }
}