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

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getAttack() {
    return attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public int getDefense() {
    return defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getExp() {
    return exp;
  }

  public void setExp(int exp) {
    this.exp = exp;
  }

  public int getNext() {
    return next;
  }

  public void setNext(int next) {
    this.next = next;
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

  public void setClassId(int classId) {
    this.classId = classId;
  }
}