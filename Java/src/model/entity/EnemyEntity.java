package model.entity;

import model.enemy.Enemy;

/**
 *
 */
public final class EnemyEntity extends Entity {

  private Enemy enemy;
  private int currentHealth;
  private int [] status;

  /**
   * Default constructor
   */
  public EnemyEntity(int x, int y, Enemy e) {
    super(x, y);
    int i;
    enemy = e;
    renderCode = e.getRenderCode();
    status = new int [5];
    for (i = 0; i < 5; i++){
      status [i] = 0;
    }
  }

  public int getCurrentHealth() {
    return currentHealth;
  }
  public void setCurrentHealth(int h) {
    currentHealth = h;
  }
  public void turn(){
    int i;
    for (i = 0; i < 5; i++){
      if (status [i] > 0){
        status [i] = status [i] - 1;
      }
    }
  }
  public boolean getStatus(int n){
    return (status[n] > 0);
  }
  public void setStatus(int n, int t){
    status[n] = t;
  }
  public Enemy getEnemy() {
    return enemy;
  }
}