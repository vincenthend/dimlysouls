import controller.EnemyController;
import controller.PlayerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Game {
  private Player player;
  private PlayerEntity playerEntity;
  private GameInterface gameInterface;
  private Map map;
  private LinkedList<EnemyController> enemyControllers;

  /**
   * Konstruktor kelas game
   */
  public Game() {
    gameInterface = new GameInterface();
    enemyControllers = new LinkedList<>();
  }

  /**
   * Menampilkan Main Menu
   */
  public void MainMenu() {
    ActionListener newGame = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        int playerClass;
        System.out.println("New Game Invoked");
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

        //Generate Map
        map = new Map(41, 21);
        map.generateMap();
        map.putEnemy();
        attachEnemyController();

        /*
        //Set Player
        playerEntity = new PlayerEntity(0, 0, player);
        gameInterface.setPlayer(playerEntity);*/

        playerEntity = new PlayerEntity(map.getMapSeed().get(map.getMapSeed().size() / 2), player);
        map.getMapCell(playerEntity.getPosition()).setEntity(playerEntity);
        gameInterface.setPlayer(playerEntity);

        //Show Interface
        gameInterface.switchToMap(new PlayerController(playerEntity, gameInterface, map), map);
        gameInterface.updateInterface();
      }
    };

    ActionListener loadGame = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Load Game Invoked");
      }
    };

    gameInterface.switchToMainMenu(newGame, loadGame);
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

  /**
   * @param args
   */
  public static void main(String[] args) {
    final Game game = new Game();
    game.MainMenu();
  }
}