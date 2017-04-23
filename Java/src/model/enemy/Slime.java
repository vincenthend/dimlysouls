package model.enemy;

/**
 *
 */
public class Slime implements Enemy {

  private int health;
  private int attack;
  private int defense;
  private int speed;
  private int expGet;
  private String renderCode;

  /**
   * Default constructor
   */
  public Slime() {
    health = 20;
    attack = 10;
    defense = 10;
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