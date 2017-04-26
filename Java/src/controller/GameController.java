package controller;

import controller.listener.BattleListener;
import controller.listener.EncounterListener;
import controller.listener.MapChangeListener;
import model.entity.EnemyEntity;
import model.entity.Entity;
import model.entity.PlayerEntity;
import model.map.Map;
import model.player.*;
import view.GameInterface;

import javax.swing.*;

/**
 * Kelas GameController mengatur berjalannya game.
 *
 * @author Mikhael Artur Darmakesuma / 13515099
 */
public class GameController extends Thread {

  private Player player;
  private PlayerEntity playerEntity;
  private GameInterface gameInterface;
  private MapController mapController;

  /**
   * Konstruktor kelas GameController.
   *
   * @param gameInterface Window Interface yang digunakan
   */
  public GameController(GameInterface gameInterface) {
    this.gameInterface = gameInterface;
  }

  /**
   * Method yang digunakan untuk memulai game baru.
   */
  public void newGame() {
    int playerClass;
    String name = JOptionPane.showInputDialog(null, "What's your name?");
    String[] options = new String[]{"Warrior", "Paladin", "Berserker", "Ninja"};
    playerClass = JOptionPane.showOptionDialog(null, "Choose your class", "Class Selection",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

    if (playerClass == 0) {
      player = new Warrior(name);
    } else if (playerClass == 1) {
      player = new Paladin(name);
    } else if (playerClass == 2) {
      player = new Berserker(name);
    } else if (playerClass == 3) {
      player = new Ninja(name);
    }

    //Nyalain map controller
    mapController = new MapController();

    Map map = mapController.getMap();
    mapController.attachEnemyController();

    //New Player
    playerEntity = new PlayerEntity(map.getMapSeed().get(map.getMapSeed().size() / 2), player);
    map.getMapCell(playerEntity.getPosition()).setEntity(playerEntity);
    gameInterface.setPlayer(playerEntity);

    //Run Map Controller
    PlayerController playerController = new PlayerController(playerEntity, gameInterface, map);

    gameInterface.switchToMap(playerController, map);
    gameInterface.updateInterface();

    GuiUpdateController guiUpdateController = new GuiUpdateController(gameInterface, map);
    guiUpdateController.mapUpdateTimer();

    //Map Change Detector
    playerController.setMapChange(new MapChangeListener() {
      @Override
      public void mapChanged(Map newMap) {
        guiUpdateController.setMap(newMap);
        mapController.stopEnemyController();
        mapController.setMap(newMap);
      }
    });

    //Encounter detector
    EncounterListener encounterListener = new EncounterListener() {
      @Override
      public void encounterFound(Entity e) {
        if (e.getEntityId() == 1) {
          gameInterface.removeKeyListener(playerController);
          //Enemy Encountered
          System.out.println("Enemy encountered");
          mapController.stopEnemyController();
          guiUpdateController.stopTimer();

          PlayerBattleController pbc = new PlayerBattleController(playerEntity, (EnemyEntity) e,
              gameInterface);

          gameInterface.switchToBattle(pbc, (EnemyEntity) e);
          gameInterface.updateInterface();

          guiUpdateController.battleUpdateTimer();
          BattleController battleController = new BattleController((EnemyEntity) e, playerEntity,
              gameInterface);
          battleController.start();
          battleController.setBattleListener(new BattleListener() {
            @Override
            public void onBattleEnd() {
              playerEntity.getPlayer().setExp(playerEntity.getPlayer().getExp() + ((EnemyEntity) e).getEnemy().getExp());
              if(playerEntity.getPlayer().isLeveling()){
                playerEntity.getPlayer().levelUp();
              }
              System.out.println("EXP = " + playerEntity.getPlayer().getExp());
              map.getEnemyList().remove(map.getEnemyList().indexOf(e));
              map.getMapCell(e.getPosition()).setEntity(null);
              map.getMapCell(playerEntity.getPosition()).setEntity(playerEntity);
              guiUpdateController.stopTimer();
              guiUpdateController.mapUpdateTimer();
              mapController.attachEnemyController();
              SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                  gameInterface.switchToMap(playerController, map);
                  gameInterface.requestFocus();
                }
              });
            }
          });
        } else if (e.getEntityId() == 2) {
          //Item Encountered
        }
      }
    };
    playerController.setEncounterListener(encounterListener);
  }
}
