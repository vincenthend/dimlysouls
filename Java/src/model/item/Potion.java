package model.item;

import model.entity.PlayerEntity;

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
    effectValue = 100;
    statAffected = HEALTH;
  }

  /**
   * Menggunakan potion.
   *
   * @param playerEntity player yang terkena efek
   */
  public void use(PlayerEntity playerEntity) {
    if (getStatAffected() == 0){
      playerEntity.setCurrentHealth(playerEntity.getCurrentHealth() + getEffectValue());
    } else if (getStatAffected() == 1){
      playerEntity.getPlayer().setExp(playerEntity.getPlayer().getExp() + getEffectValue());
    }
  }

  /**
   * Mengembalikan nilai effect.
   *
   * @return nilai effect potion
   */
  public int getEffectValue() {
    return effectValue;
  }

  /**
   * Mengembalikan stats yang terkena efek.
   *
   * @return kode stats yang terkena efek.
   */
  public int getStatAffected() {
    return statAffected;
  }
}