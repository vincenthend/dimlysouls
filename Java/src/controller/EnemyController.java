package controller;

import java.util.Random;
import model.entity.EnemyEntity;
import model.map.Map;

/**
 * Class EnemyControler mengatur pergerakan musuh di map
 *
 * @Author Mikhael Artur Darmakesuma / 13515099
 */
public class EnemyController extends Thread {
  private EnemyEntity enemyEntity;
  private boolean isRunning;
  private Map map;

  /**
   * Konstruktro enemycontroller
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
   * Menjalankan thread EnemyController
   */
  public void run() {
    int move;
    Random rand = new Random();
    rand.setSeed(System.currentTimeMillis());

    try {
      sleep(1000 / enemyEntity.getEnemy().getSpeed());
      move = -1;
      while (move == -1) {
        move = rand.nextInt(4);
        if (move == 0) {
          if (map.inBounds(enemyEntity.getPosition()) && map.getMapCell()) {

          }
          else {
            move = -1;
          }
        }
        else if (move == 1) {
          if () {

          }
          else {
            move = -1;
          }
        }
        else if (move == 2) {
          if () {

          }
          else {
            move = -1;
          }
        }
        else if (move == 3) {
          if () {

          }
          else {
            move = -1;
          }
        }
      }
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
  }

  /**
   * Mematikan thread EnemyController
   */
  public void kill() {
    isRunning = false;
  }
}
