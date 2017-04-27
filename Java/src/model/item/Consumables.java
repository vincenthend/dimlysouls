package model.item;

import model.entity.PlayerEntity;

/**
 * Interface Consumables, berisi benda consumables.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public interface Consumables {

  final int HEALTH = 0;
  final int EXP = 1;

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
   *
   * @param playerEntity Player yang terkena efek
   */
  public void use(PlayerEntity playerEntity);
}