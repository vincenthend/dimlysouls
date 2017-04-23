package model.player;

/**
 *
 */
public abstract class Player {
  protected int health;
  protected int attack;
  protected int defense;
  protected int speed;
  protected int level;
  protected int exp;
  protected int next;
  protected String nama;
  protected final int classId;

  public Player() {
    classId = 0;
  }

  public Player(int classId, String nama) {
    this.classId = classId;
    this.nama = nama;
  }

  /**
   * Menambah level player dan mengurangi nilai exp dengan nilai next.
   * Mengubah nilai next sesuai dengan rumus level^2 + offset
   */
  public void levelUp() {
    exp -= exp;
    next = next * 3 / 2;
    level++;
  }

  /**
   * Mengecek apakah player harus level up
   */
  public boolean isLeveling() {
    return exp >= next;
  }

  public int getHealth() {
    return health;
  }

  public int getAttack() {
    return attack;
  }

  public int getDefense() {
    return defense;
  }

  public int getSpeed() {
    return speed;
  }

  public int getLevel() {
    return level;
  }

  public int getExp() {
    return exp;
  }

  public int getNext() {
    return next;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public int getClassId() {
    return classId;
  }
}