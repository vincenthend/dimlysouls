package model.player;

/**
 * Kelas berserker.
 *
 * @author Mikhael A D / 13515099
 */
public class Berserker implements Player {

  private final int classId;
  private int health;
  private int attack;
  private int defense;
  private int speed;
  private int level;
  private int exp;
  private int next;
  private String nama;

  /**
   * Konstruktor kelas berserker.
   *
   * @param nama nama pemain
   */
  public Berserker(String nama) {
    this.nama = nama;
    classId = 1;
    health = 200;
    attack = 15;
    defense = 8;
    speed = 1;
    level = 1;
    exp = 0;
    next = 10;
  }

  /**
   * Menambah level player dan mengurangi nilai exp dengan nilai next.
   * Mengubah nilai next sesuai dengan rumus next * k + offset
   */
  @Override
  public void levelUp() {
    exp -= next;
    next = next * 3 / 2 + 5;
    level++;
    health += 20;
    attack += 2;
    defense += 1;
    speed += 1;
  }

  /**
   * Mengecek apakah player harus level up.
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

  public void setExp(int exp) {
    this.exp = exp;
  }

  public int getNext() {
    return next;
  }

  public String getNama() {
    return nama;
  }

  public int getClassId() {
    return classId;
  }

  public void special(int selfDamage, int enemyDamage, int[] selfStatus, int[] enemyStatus) {
    selfDamage = attack;
    enemyDamage = attack * 2;
    selfStatus[1] = 3;
  }
}