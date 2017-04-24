package controller;

import java.awt.Point;
import java.util.Random;
import model.entity.EnemyEntity;
import model.entity.Entity;
import model.map.Cell;
import model.map.Map;
import view.GameInterface;

/**
 * Class EnemyControler mengatur pergerakan musuh di map
 *
 * @Author Mikhael Artur Darmakesuma / 13515099
 */
public class EnemyController extends Thread {
  private EnemyEntity enemyEntity;
  private boolean isRunning;
  private Map map;
  private GameInterface gui;

  /**
   * Konstruktor EnemyController.
   *
   * @param enemyEntity musuh yang digerakkan
   * @param M peta yang digunakan untuk navigasi
   */
  public EnemyController(EnemyEntity enemyEntity, Map M, GameInterface gui) {
    this.enemyEntity = enemyEntity;
    map = M;
    isRunning = true;
    this.gui = gui;
  }

  /**
   * Menjalankan thread EnemyController.
   */
  public void run() {
    int move;
    Random rand = new Random();
    rand.setSeed(System.currentTimeMillis());
    Cell tempCell;
    Point tempPoint;

    try {
      while (isRunning) {
        //synchronized (enemyEntity) {
          Thread.sleep(10000 / enemyEntity.getEnemy().getSpeed());
          move = -1;
          while (move == -1) {
            move = rand.nextInt(4);
            if (move == 0) {
              if (map.inBounds(enemyEntity.getPosition(Entity.LEFT))) {
                if (map.getMapCell(enemyEntity.getPosition(Entity.LEFT)).getTerrain()
                    .isPassable()) {
                  tempCell = map.getMapCell(enemyEntity.getPosition());
                  tempCell.setEntity(null);
                  tempCell = map.getMapCell(enemyEntity.getPosition(Entity.LEFT));
                  tempCell.setEntity(enemyEntity);
                  enemyEntity.move(Entity.LEFT);
                }
                else {
                  move = -1;
                }
              }
            }
            else if (move == 1) {
              if (map.inBounds(enemyEntity.getPosition(Entity.RIGHT))) {
                if (map.getMapCell(enemyEntity.getPosition(Entity.RIGHT)).getTerrain()
                    .isPassable()) {
                  tempCell = map.getMapCell(enemyEntity.getPosition());
                  tempCell.setEntity(null);
                  tempCell = map.getMapCell(enemyEntity.getPosition(Entity.RIGHT));
                  tempCell.setEntity(enemyEntity);
                  enemyEntity.move(Entity.RIGHT);
                }
                else {
                  move = -1;
                }
              }
            }
            else if (move == 2) {
              if (map.inBounds(enemyEntity.getPosition(Entity.UP))) {
                if (map.getMapCell(enemyEntity.getPosition(Entity.UP)).getTerrain()
                    .isPassable()) {
                  tempCell = map.getMapCell(enemyEntity.getPosition());
                  tempCell.setEntity(null);
                  tempCell = map.getMapCell(enemyEntity.getPosition(Entity.UP));
                  tempCell.setEntity(enemyEntity);
                  enemyEntity.move(Entity.UP);
                }
                else {
                  move = -1;
                }
              }
            }
            else if (move == 3) {
              if (map.inBounds(enemyEntity.getPosition(Entity.DOWN))) {
                if (map.getMapCell(enemyEntity.getPosition(Entity.DOWN)).getTerrain()
                    .isPassable()) {
                  tempCell = map.getMapCell(enemyEntity.getPosition());
                  tempCell.setEntity(null);
                  tempCell = map.getMapCell(enemyEntity.getPosition(Entity.DOWN));
                  tempCell.setEntity(enemyEntity);
                  enemyEntity.move(Entity.DOWN);
                }
                else {
                  move = -1;
                }
              }
            }
          }
        //}

        //System.out.println(enemyEntity.getPosition().toString());
        gui.getMapInterface().updateMap(map);
        gui.updateInterface();
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
