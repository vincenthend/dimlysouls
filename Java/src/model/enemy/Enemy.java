package model.enemy;

/**
 *
 */
public interface Enemy {
  /**
   * @return
   */
  public int getHealth();
  /**
   * @return
   */
  public int getAttack();
  /**
   * @return
   */
  public int getDefense();
  /**
   * @return
   */
  public int getSpeed();
  /**
   * @return
   */
  public int getExp();
  /**
   * @return
   */
  public String getRenderCode();
}