package controller;

import java.awt.Point;
import java.util.Random;
import model.entity.EnemyEntity;
import model.map.Cell;
import model.map.Map;

/**
 * Class EnemyControler mengatur pergerakan musuh di map
 *
 * @author Mikhael Artur Darmakesuma / 13515099
 */
public class EnemyController extends Thread {
  private EnemyEntity enemyEntity;
  private boolean isRunning;
  private Map map;

  /**
   * Konstruktor EnemyController.
   *
   * @param enemyEntity musuh yang digerakkan
   * @param M peta yang digunakan untuk navigasi
   */
  public EnemyController(EnemyEntity enemyEntity, Map M) {
    this.enemyEntity = enemyEntity;
    map = M;
    isRunning = true;
  }

  /**
   * Menjalankan thread EnemyController.
   */
  public synchronized void run() {
    int move;
    Random rand = new Random();
    rand.setSeed(System.currentTimeMillis());
    Cell tempCell;
    Point tempPoint;
    boolean moving;
    try {
      while (isRunning) {
        Thread.sleep(10000 / enemyEntity.getEnemy().getSpeed());
        move = -1;
        moving = false;
        while (!moving) {
          move = rand.nextInt(4);
          if (isDirPassable(move)) {
            map.getMapCell(enemyEntity.getPosition(move)).setEntity(enemyEntity);
            map.getMapCell(enemyEntity.getPosition()).setEntity(null);
            enemyEntity.move(move);
            moving = true;
          }
        }
      }
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
  }

  /**
   * Mengembalikan nilai apakah jalan dapat dilalui
   * @param direction
   * @return
   */
  private boolean isDirPassable(int direction) {
    return (map.inBounds(enemyEntity.getPosition(direction)) && map
        .getMapCell(enemyEntity.getPosition(direction)).getTerrain().isPassable() && map
        .getMapCell(enemyEntity.getPosition(direction)).getEntity() == null);
  }

  /**
   * Mematikan thread EnemyController.
   */
  public void kill() {
    isRunning = false;
  }
}
