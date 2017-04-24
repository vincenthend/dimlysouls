package model.item;

import model.player.Player;

/**
 * Interface Consumables, berisi benda consumables
 */
public interface Consumables {
  /**
   * Mengambil nilai efek
   * @return nilai efek yangg diberikan
   */
  public int getEffectValue();
  /**
   * Mengambil nilai status yang terkena efek
   * @return status yang terkena efek
   */
  public int getStatAffected();
  /**
   * Menggunakan consumables
   */
  public void use(Player player);
}