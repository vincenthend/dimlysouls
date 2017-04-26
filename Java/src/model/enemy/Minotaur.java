package model.enemy;

/**
 * Kelas musuh minotaur.
 *
 * @author Adrian Mulyana / 13515075
 */
public class Minotaur implements Enemy {

  private int health;
  private int attack;
  private int defense;
  private int speed;
  private int expGet;
  private String renderCode;

  /**
   * Konstruktor kelas minotaur.
   */
  public Minotaur() {
    health = 10000;
    attack = 20;
    defense = 10;
    speed = 15;
    expGet = 100;
    renderCode = "!";
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