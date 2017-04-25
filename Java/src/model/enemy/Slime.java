package model.enemy;

/**
 * Kelas musuh slime.
 * @author
 */
public class Slime implements Enemy {
  private int health;
  private int attack;
  private int defense;
  private int speed;
  private int expGet;
  private String renderCode;

  /**
   * Konstruktor kelas slime.
   */
  public Slime() {
    health = 20;
    attack = 3;
    defense = 3;
    speed = 50;
    expGet = 5;
    renderCode = "$";
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