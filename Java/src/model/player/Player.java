package model.player;

/**
 * Interface player.
 *
 * @author Mikhael A D/ 13515099
 */
public interface Player {

  /**
   * Menambah level player dan mengurangi nilai exp dengan nilai next.
   * Mengubah nilai next sesuai dengan rumus next * k + offset.
   */
  void levelUp();

  /**
   * Mengecek apakah player harus level up.
   *
   * @return nilai apakah player harus level up
   */
  boolean isLeveling();

  // Getter & Setter
  int getHealth();

  int getAttack();

  int getDefense();

  int getSpeed();

  int getLevel();

  int getExp();

  void setExp(int exp);

  int getNext();

  String getNama();

  int getClassId();

  void special(int selfDamage, int enemyDamage, int[] selfStatus, int[] enemyStatus);
}
