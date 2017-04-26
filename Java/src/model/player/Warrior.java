package model.player;

import java.util.Random;

/**
 * Kelas Warrior.
 *
 * @author Mikhael A D/ 13515099
 */
public class Warrior implements Player {

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
   * Konstruktor kelas Warrior.
   *
   * @param nama nama pemain
   */
  public Warrior(String nama) {
    this.nama = nama;
    classId = 4;
    health = 150;
    attack = 10;
    defense = 10;
    speed = 4;
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
    while (isLeveling()){
      exp -= next;
      next = next * 3 / 2 + 5;
      level++;
      health += 15;
      attack += 2;
      defense += 2;
      speed += 1;
    }
  }

  /**
   * Mengecek apakah player harus level up.
   */
  public boolean isLeveling() {
    return exp >= next;
  }

  // Getter & Setter

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
    Random rand = new Random();
    int i = rand.nextInt(10);
    if (i > 5){
      enemyDamage = attack * 2;
      enemyStatus[4] = 3;
    }
    else {
      enemyDamage = attack;
    }
  }
}