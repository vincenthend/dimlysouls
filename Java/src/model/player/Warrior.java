package model.player;

/**
 *
 */
public class Warrior extends Player {
  /**
   * Default constructor
   */
  public Warrior(String nama) {
    super(1, nama);
    health = 150;
    attack = 10;
    defense = 10;
    level = 1;
    exp = 0;
    next = 10;
  }

  @Override
  public void levelUp() {
    super.levelUp();
    health += 15;
    attack += 2;
    defense += 1;
  }
}