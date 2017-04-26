package model.item;

import model.player.Player;

/**
 * Kelas potion, implemen consumables.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public class Potion implements Consumables {

  private int effectValue;
  private int statAffected;

  /**
   * Konstruktor kelas potion.
   */
  public Potion() {
  }

  /**
   * Menggunakan potion.
   *
   * @param player player yang terkena efek
   */
  public void use(Player player) {
    // TODO implement here
  }

  /**
   * Mengembalikan nilai effect.
   *
   * @return nilai effect potion
   */
  public int getEffectValue() {
    // TODO implement here
    return 0;
  }

  /**
   * Mengembalikan stats yang terkena efek.
   *
   * @return kode stats yang terkena efek.
   */
  public int getStatAffected() {
    // TODO implement here
    return 0;
  }
}