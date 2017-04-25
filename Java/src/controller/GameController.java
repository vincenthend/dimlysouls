package controller;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import model.map.Map;
import model.player.Berserker;
import model.player.Ninja;
import model.player.Paladin;
import model.player.Player;
import model.player.Warrior;
import view.GameInterface;

public class GameController {
  private Player player;
  private PlayerEntity playerEntity;
  private Map map;
  private GameInterface gameInterface;
  private LinkedList<EnemyController> enemyControllers;

  public GameController(GameInterface gameInterface) {
    this.gameInterface = gameInterface;
    enemyControllers = new LinkedList<>();
  }

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
    //Generate Map
    map = new Map(41, 21);
    map.generateMap();
    map.putEnemy();
    attachEnemyController();

    //New Player
    playerEntity = new PlayerEntity(map.getMapSeed().get(map.getMapSeed().size() / 2), player);
    map.getMapCell(playerEntity.getPosition()).setEntity(playerEntity);
    gameInterface.setPlayer(playerEntity);

    //Run Map Controller
    gameInterface.switchToMap(new PlayerController(playerEntity, gameInterface, map), map);
    gameInterface.updateInterface();
  }

  public void attachEnemyController() {
    LinkedList<EnemyEntity> enemyList = map.getEnemyList();
    EnemyController enemyController;
    int i;
    System.out.println(enemyList.size());
    for (i = 0; i < enemyList.size(); i++) {
      enemyController = new EnemyController(enemyList.get(i), map, gameInterface);
      enemyControllers.addLast(enemyController);
      enemyController.start();
    }
  }
}
