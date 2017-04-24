package model.player;

/**
 *
 */
public interface Player {
  /**
   * Menambah level player dan mengurangi nilai exp dengan nilai next.
   * Mengubah nilai next sesuai dengan rumus next * k + offset
   */
  public void levelUp();
  /**
   * Mengecek apakah player harus level up
   */
  public boolean isLeveling();
  // Getter & Setter
  public int getHealth();
  public int getAttack();
  public int getDefense();
  public int getSpeed();
  public int getLevel();
  public int getExp();
  public int getNext();
  public String getNama();
  public int getClassId();
}