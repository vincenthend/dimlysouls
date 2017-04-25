package controller;

import model.entity.EnemyEntity;
import view.GameInterface;

import java.util.Random;

/**
 * Class EnemyControler mengatur pergerakan musuh di map
 *
 * @Author Mikhael Artur Darmakesuma / 13515099
 */
public class EnemyController extends Thread {
  private EnemyEntity enemyEntity;
  private boolean isRunning;
  private GameInterface gui;

  /**
   * Konstruktor EnemyController.
   *
   * @param enemyEntity musuh yang digerakkan
   */
  public EnemyController(EnemyEntity enemyEntity, GameInterface gui) {
    this.enemyEntity = enemyEntity;
    isRunning = true;
    this.gui = gui;
  }

  /**
   * Menjalankan thread EnemyController.
   */
  public synchronized void run() {
    int move;
    Random rand = new Random();
    rand.setSeed(System.currentTimeMillis());
    boolean moving;
    try {
      while (isRunning) {
        Thread.sleep(15000 / enemyEntity.getEnemy().getSpeed());
        move = -1;
        moving = false;
        while (!moving) {
          move = rand.nextInt(4);
          if (isDirPassable(move)) {
            PlayerController.map.getMapCell(enemyEntity.getPosition(move)).setEntity(enemyEntity);
            PlayerController.map.getMapCell(enemyEntity.getPosition()).setEntity(null);
            enemyEntity.move(move);
            moving = true;
          }
        }

        gui.updateMap(PlayerController.map);
        gui.updateInterface();
      }
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
  }

  private boolean isDirPassable(int direction) {
    return (PlayerController.map.inBounds(enemyEntity.getPosition(direction)) && PlayerController.map
        .getMapCell(enemyEntity.getPosition(direction)).getTerrain().isPassable() && PlayerController.map
        .getMapCell(enemyEntity.getPosition(direction)).getEntity() == null);
  }

  /**
   * Mematikan thread EnemyController
   */
  public void kill() {
    isRunning = false;
  }
}
