package model.entity;

import model.enemy.Enemy;

/**
 *
 */
public final class EnemyEntity extends Entity {

  private Enemy enemy;
  private int currentHealth;

  /**
   * Default constructor
   */
  public EnemyEntity(int x, int y, Enemy e) {
    super(x, y);
    enemy = e;
    renderCode = e.getRenderCode();
  }


  public int getCurrentHealth() {
    return currentHealth;
  }

  public Enemy getEnemy() {
    return enemy;
  }
}