package model.entity;

import java.awt.Point;
import model.enemy.Enemy;

/**
 * Entity yang berisi enemy.
 *
 * @author Vincent Hendryanto H/ 13515089
 */
public final class EnemyEntity extends Entity {

  private Enemy enemy;
  private int currentHealth;
  private int[] status;

  /**
   * Konstruktor EnemyEntity.
   *
   * @param x absis objek enemy
   * @param y ordinat objek enemy
   * @param e musuh di dalam entity
   */
  public EnemyEntity(int x, int y, Enemy e) {
    super(x, y, 1);
    enemy = e;
    renderCode = e.getRenderCode();
    currentHealth = e.getHealth();
    status = new int[5];
    int i;
    for (i = 0; i < 5; i++) {
      status[i] = 0;
    }
  }

  /**
   * Konstruktor EnemyEntity.
   * @param location lokasi musuh
   * @param e musuh yang terlibat
   */
  public EnemyEntity(Point location, Enemy e) {
    super(location, 1);

    enemy = e;
    renderCode = e.getRenderCode();
    currentHealth = e.getHealth();
    status = new int[5];
    int i;
    for (i = 0; i < 5; i++) {
      status[i] = 0;
    }
  }

  /**
   * Mengembalikan nilai health musuh.
   *
   * @return nilai health musuh
   */
  public int getCurrentHealth() {
    return currentHealth;
  }

  /**
   * Mengatur nilai health musuh.
   *
   * @param h nilai health musuh
   */
  public void setCurrentHealth(int h) {
    currentHealth = h;
  }

  /**
   * Menghitung turn.
   */
  public void turn() {
    int i;
    for (i = 0; i < 5; i++) {
      if (status[i] > 0) {
        status[i] = status[i] - 1;
      }
    }
  }

  /**
   * Mengembalikan status ke n dari player.
   *
   * @param n status yang dicari
   * @return nilai status n
   */
  public boolean getStatus(int n) {
    return (status[n] > 0);
  }

  /**
   * Memasangkan status player.
   *
   * @param n kode status
   * @param t nilai status
   */
  public void setStatus(int n, int t) {
    status[n] = t;
  }

  /**
   * Mengembalikan enemy yang ada di dalam entity.
   *
   * @return enemy di dalam entity
   */
  public Enemy getEnemy() {
    return enemy;
  }
}