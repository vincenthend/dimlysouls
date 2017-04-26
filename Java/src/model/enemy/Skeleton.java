package model.enemy;

/**
 * Kelas musuh skeleton.
 *
 * @author Adrian Mulyana / 13515075
 */
public class Skeleton implements Enemy {

  private int health;
  private int attack;
  private int defense;
  private int speed;
  private int expGet;
  private String renderCode;

  /**
   * Konstruktor kelas skeleton.
   */
  public Skeleton() {
    health = 5000;
    attack = 25;
    defense = 15;
    speed = 35;
    expGet = 45;
    renderCode = "X";
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