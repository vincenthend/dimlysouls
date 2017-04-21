package model.player;

/**
 *
 */
public abstract class Player {


  private int health;
  private int attack;
  private int defense;
  private int level;
  private int exp;
  private int next;
  private String nama;
  private int classId;

  /**
   * /**
   * Default constructor
   */
  public Player() {
  }

  /**
   * Menambah level player dan mengurangi nilai exp dengan nilai next.
   * Mengubah nilai next sesuai dengan rumus level^2 + offset
   */
  void levelUp() {
    // TODO implement here
  }

  /**
   * Mengecek apakah player harus level up
   */
  boolean isLeveling() {
    // TODO implement here
    return false;
  }

}