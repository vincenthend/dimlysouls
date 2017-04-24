package model.player;

/**
 *
 */
public interface Player {
  /**
   * Menambah level player dan mengurangi nilai exp dengan nilai next.
   * Mengubah nilai next sesuai dengan rumus next * k + offset
   */
  void levelUp();
  /**
   * Mengecek apakah player harus level up
   */
  boolean isLeveling();
  // Getter & Setter
<<<<<<< HEAD
  int getHealth();
  int getAttack();
  int getDefense();
  int getSpeed();
  int getLevel();
  int getExp();
  int getNext();
  String getNama();
  int getClassId();
  void special(int selfDamage, int enemyDamage, int[] selfStatus, int enemyStatus[]);
=======
  public int getHealth();
  public int getAttack();
  public int getDefense();
  public int getSpeed();
  public int getLevel();
  public int getExp();
  public int getNext();
  public String getNama();
  public int getClassId();
>>>>>>> 5876874bce183771fcf07f42c322ec596736c053
}