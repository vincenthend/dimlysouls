package model.entity;

import model.enemy.Enemy;

/**
 *
 */
public final class EnemyEntity extends Entity {

  private Enemy enemyType;
  private int currentHealth;

  /**
   * Default constructor
   */
  public EnemyEntity() {
  }


  public int getCurrentHealth() {
    return currentHealth;
  }
}