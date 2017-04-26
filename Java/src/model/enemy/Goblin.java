package model.enemy;

/**
 * Kelas musuh goblin.
 * @author
 */
public class Goblin implements Enemy {
  private int health;
  private int attack;
  private int defense;
  private int speed;
  private int expGet;
  private String renderCode;

  /**
   * Konstruktor kelas goblin.
   */
  public Goblin() {
    health = 35;
    attack = 15;
    defense = 15;
    speed = 70;
    expGet = 20;
    renderCode = "@";
  }

  @Override
  public int getHealth() {
    return health;
  }

  @Override
  public int getAttack() {
    return attack;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public int getSpeed() {
    return speed;
  }

  @Override
  public int getExp() {
    return expGet;
  }

  @Override
  public String getRenderCode() {
    return renderCode;
  }
}