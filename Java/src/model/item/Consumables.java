package model.item;

import model.player.Player;

/**
 * Interface Consumables, berisi benda consumables.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public interface Consumables {

  /**
   * Mengambil nilai efek.
   *
   * @return nilai efek yangg diberikan
   */
  public int getEffectValue();

  /**
   * Mengambil nilai status yang terkena efek.
   *
   * @return status yang terkena efek
   */
  public int getStatAffected();

  /**
   * Menggunakan consumables.
   */
  public void use(Player player);
}