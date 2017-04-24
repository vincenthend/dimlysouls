package controller;

import model.entity.EnemyEntity;
import model.entity.Entity;
import model.map.Map;

import java.util.Random;

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
  public void run() {
    int move;
    Random rand = new Random();
    rand.setSeed(System.currentTimeMillis());

    try {
      sleep(1000 / enemyEntity.getEnemy().getSpeed());
      move = -1;
      while (move == -1) {
        move = rand.nextInt(4);
        if (move == 0){
          if (map.inBounds(enemyEntity.getPosition(Entity.LEFT)) && map.getMapCell(enemyEntity.getPosition(Entity.LEFT)).getTerrain().isPassable()){
            map.setMapCell(map.getMapCell(enemyEntity.getPosition()), enemyEntity.getPosition(Entity.LEFT));
            map.setMapCell(null, enemyEntity.getPosition());
            enemyEntity.move(Entity.LEFT);
          }
          else {
            move = -1;
          }
        }
        else if (move == 1){
          if (map.inBounds(enemyEntity.getPosition(Entity.RIGHT)) && map.getMapCell(enemyEntity.getPosition(Entity.RIGHT)).getTerrain().isPassable()){
            map.setMapCell(map.getMapCell(enemyEntity.getPosition()), enemyEntity.getPosition(Entity.RIGHT));
            map.setMapCell(null, enemyEntity.getPosition());
            enemyEntity.move(Entity.RIGHT);
          }
          else {
            move = -1;
          }
        }
        else if (move == 2){
          if (map.inBounds(enemyEntity.getPosition(Entity.UP)) && map.getMapCell(enemyEntity.getPosition(Entity.UP)).getTerrain().isPassable()){
            map.setMapCell(map.getMapCell(enemyEntity.getPosition()), enemyEntity.getPosition(Entity.UP));
            map.setMapCell(null, enemyEntity.getPosition());
            enemyEntity.move(Entity.UP);
          }
          else {
            move = -1;
          }
        }
        else if (move == 3){
          if (map.inBounds(enemyEntity.getPosition(Entity.DOWN)) && map.getMapCell(enemyEntity.getPosition(Entity.DOWN)).getTerrain().isPassable()){
            map.setMapCell(map.getMapCell(enemyEntity.getPosition()), enemyEntity.getPosition(Entity.DOWN));
            map.setMapCell(null, enemyEntity.getPosition());
            enemyEntity.move(Entity.DOWN);
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
