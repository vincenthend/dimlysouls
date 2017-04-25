package controller;

import java.util.LinkedList;
import model.entity.EnemyEntity;
import model.map.Map;

/**
 * Created by vince on 25/04/2017.
 */
public class MapController {
  private Map map;
  private LinkedList<EnemyController> enemyControllers;

  public MapController() {
    //Generate Map
    map = new Map(41, 21);
    map.generateMap();
    map.putEnemy();

    enemyControllers = new LinkedList<>();

    attachEnemyController();
  }

  public void attachEnemyController() {
    LinkedList<EnemyEntity> enemyList = map.getEnemyList();
    EnemyController enemyController;
    int i;
    for (i = 0; i < enemyList.size(); i++) {
      enemyController = new EnemyController(enemyList.get(i), map);
      enemyControllers.addLast(enemyController);
      enemyController.start();
    }
  }

  public void stopEnemyController() {
    int i;
    for (i = 0; i < enemyControllers.size(); i++) {
      enemyControllers.get(i).kill();
    }
  }

  public void setMap(Map map) {
    this.map = map;
    enemyControllers = new LinkedList<>();
    attachEnemyController();
  }

  public Map getMap() {
    return map;
  }
}

