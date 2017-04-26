package controller;

import controller.listener.EncounterListener;
import model.entity.EnemyEntity;
import model.entity.Entity;
import model.entity.PlayerEntity;
import model.map.Map;
import view.GameInterface;

/**
 * Class EnemyControler mengatur pergerakan musuh di map
 *
 * @author Mikhael Artur Darmakesuma / 13515099
 */
public class TransitionController extends Thread {
    private GuiUpdateController guiUpdateController;
    private MapController mapController;
    private GameInterface gameInterface;
    private EnemyEntity enemyEntity;
    private PlayerController playerController;
    private Map map;
    private PlayerEntity playerEntity;

    /**
     * Konstruktor EnemyController.
     *
     */
    public TransitionController(GuiUpdateController guiUpdateController, MapController mapController, GameInterface gameInterface, EnemyEntity enemyEntity, PlayerController playerController, Map map, PlayerEntity playerEntity) {
        this.guiUpdateController = guiUpdateController;
        this.mapController = mapController;
        this.gameInterface = gameInterface;
        this.enemyEntity = enemyEntity;
        this.playerController = playerController;
        this.map = map;
        this.playerEntity = playerEntity;
    }

    /**
     * Menjalankan thread EnemyController.
     */
    public synchronized void run() {
        while (enemyEntity.getCurrentHealth() > 0) {
            System.out.println("CEK");
        }
        guiUpdateController.stopTimer();
        mapController.attachEnemyController();
        gameInterface.switchToMap(playerController, map);
        playerController.setEncounterListener(new EncounterListener() {
            @Override
            public void EncounterFound(Entity e) {
                if (e.getEntityId() == 1) {
                    //Enemy Encountered
                    System.out.println("Enemy encountered");
                    BattleController battleController = new BattleController((EnemyEntity) e, playerEntity,
                            gameInterface);
                    mapController.stopEnemyController();
                    guiUpdateController.stopTimer();

                    guiUpdateController.battleUpdateTimer();
                    battleController.start();

                    //Switch back to map
                    TransitionController transitionController = new TransitionController(guiUpdateController, mapController, gameInterface, (EnemyEntity) e, playerController, map, playerEntity);
                    transitionController.start();
                }
                else if (e.getEntityId() == 2) {
                    //Item Encountered
                }
            }
        });
        guiUpdateController.mapUpdateTimer();
        System.out.println("CEKs");
    }
}
