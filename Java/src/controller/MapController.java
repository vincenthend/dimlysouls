package controller;

import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import model.map.Map;
import view.GameInterface;

import java.util.LinkedList;

public class MapController {
    private static final int defaultMapWidth = 41;
    private static final int defaultMapHeight = 21;
    private Map map;
    private int status;
    private GameInterface gameInterface;
    private LinkedList<EnemyController> enemyControllers;
    private PlayerController playerController;
    public MapController(PlayerEntity playerEntity, GameInterface gameInterface){
        status = 0;
        this.gameInterface = gameInterface;
        map = new Map(defaultMapWidth, defaultMapHeight);
        map.generateMap();
        map.putEnemy();
        enemyControllers = new LinkedList<>();
        playerController = new PlayerController(playerEntity, gameInterface, map);
        attachEnemyController();
        playerEntity.setPosition(map.getMapSeed().get(map.getMapSeed().size() / 2));
        map.getMapCell(playerEntity.getPosition()).setEntity(playerEntity);
        gameInterface.setPlayer(playerEntity);
        gameInterface.switchToMap(new PlayerController(playerEntity, gameInterface, map), map);
        gameInterface.updateInterface();
    }
    public void attachEnemyController() {
        LinkedList<EnemyEntity> enemyList = map.getEnemyList();
        EnemyController enemyController;
        int i;
        System.out.println(enemyList.size());
        for (i = 0; i < enemyList.size(); i++) {
            enemyController = new EnemyController(enemyList.get(i), gameInterface);
            enemyControllers.addLast(enemyController);
            enemyController.start();
        }
    }
}
