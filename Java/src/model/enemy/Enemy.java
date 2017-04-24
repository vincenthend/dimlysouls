package model.enemy;

/**
 * Interface enemy, mengatur getter yang harus dimiliki enemy.
 * @author
 */
public interface Enemy {
  /**
   * Mengembalikan nilai health.
   * @return nilai health
   */
  public int getHealth();
  /**
   * Mengembalikan nilai Attack.
   * @return nilai Attack
   */
  public int getAttack();
  /**
   * Mengembalikan nilai Defense.
   * @return nilai Defense
   */
  public int getDefense();
  /**
   * Mengembalikan nilai Speed.
   * @return nilai speed
   */
  public int getSpeed();
  /**
   * Mengembalikan nilai EXP yang didapat.
   * @return nilai exp
   */
  public int getExp();
  /**
   * Mengembalikan RenderCode.
   * @return renderCode
   */
  public String getRenderCode();
}