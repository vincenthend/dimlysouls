package model.player;

import java.util.Random;

/**
 * Kelas ninja.
 *
 * @author Mikhael A D/ 13515099
 */
public class Ninja implements Player {

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
   * Konstruktor kelas ninja.
   *
   * @param nama nama pemain
   */
  public Ninja(String nama) {
    this.nama = nama;
    classId = 2;
    health = 100;
    attack = 5;
    defense = 7;
    speed = 10;
    level = 1;
    exp = 0;
    next = 10;
  }

  /**
   * Menambah level player dan mengurangi nilai exp dengan nilai next.
   * Mengubah nilai next sesuai dengan rumus next * k + offset.
   */
  @Override
  public void levelUp() {
    exp -= next;
    next = next * 3 / 2 + 5;
    level++;
    health += 10;
    attack += 1;
    defense += 1;
    speed += 3;
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

  /**
   * Special attack.
   * @param selfDamage damage ke diri sendiri
   * @param enemyDamage damage ke musuh
   * @param selfStatus status diri sendiri
   * @param enemyStatus status musuh
   */
  public void special(int selfDamage, int enemyDamage, int[] selfStatus, int[] enemyStatus) {
    Random rand = new Random();
    int i = rand.nextInt(10);
    if (i > 5) {
      enemyDamage = attack * 2;
      enemyStatus[3] = 3;
    } else {
      enemyDamage = attack;
    }
  }
}