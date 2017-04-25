package controller;

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
   * Method yang digunakan untuk memulai game baru
   */
  public void newGame() {
    int playerClass;
    String name = JOptionPane.showInputDialog(null, "What's your name?");
    String[] options = new String[] {"Warrior", "Paladin", "Berserker", "Ninja"};
    playerClass = JOptionPane.showOptionDialog(null, "Choose your class", "Class Selection",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

    if (playerClass == 0) {
      player = new Warrior(name);
    }
    else if (playerClass == 1) {
      player = new Paladin(name);
    }
    else if (playerClass == 2) {
      player = new Berserker(name);
    }
    else if (playerClass == 3) {
      player = new Ninja(name);
    }

    //Nyalain map controller
    mapController = new MapController();

    Map map = mapController.getMap();

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
          playerController.setEncounterListener(null);
          TransitionController transitionController = new TransitionController(guiUpdateController, mapController, gameInterface, (EnemyEntity) e, playerController, map, playerEntity);
          transitionController.start();
        }
        else if (e.getEntityId() == 2) {
          //Item Encountered
        }
      }
    });
  }
}
