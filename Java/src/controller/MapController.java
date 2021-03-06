package controller;

import java.util.LinkedList;
import model.entity.EnemyEntity;
import model.map.Map;

/**
 * Kelas MapController, mengatur pembuatan dan generasi map beserta isinya.
 */
public class MapController {

  private Map map;
  private LinkedList<EnemyController> enemyControllers;

  /**
   * Konstruktor kelas MapController.
   */
  public MapController() {
    //Generate Map
    map = new Map(41, 21);
    map.generateMap();
    map.putEnemy();
    map.putItem();

  }

  /**
   * Melakukan penambahan EnemyController pada tiap enemy.
   */
  public void attachEnemyController() {
    enemyControllers = new LinkedList<>();
    LinkedList<EnemyEntity> enemyList = map.getEnemyList();
    EnemyController enemyController;
    int i;
    for (i = 0; i < enemyList.size(); i++) {
      enemyController = new EnemyController(enemyList.get(i), map);
      enemyControllers.addLast(enemyController);
      enemyController.start();
    }
  }

  /**
   * Menghentikan semua EnemyController yang berjalan.
   */
  public void stopEnemyController() {
    int i;
    for (i = 0; i < enemyControllers.size(); i++) {
      enemyControllers.get(i).kill();
    }
  }

  /**
   * Mengembalikan map yang berjalan sekarang.
   *
   * @return map yang berjalan saat ini
   */
  public Map getMap() {
    return map;
  }

  /**
   * Melakukan inisialisasi pada current map.
   *
   * @param map map yang digunakan sekarang
   */
  public void setMap(Map map) {
    this.map = map;
    enemyControllers = new LinkedList<>();
    attachEnemyController();
  }
}

