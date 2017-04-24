import controller.EnemyController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import model.entity.EnemyEntity;
import model.entity.Entity;
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

        //Set Player
        playerEntity = new PlayerEntity(0, 0, player);
        gameInterface.setPlayer(playerEntity);

        //Generate Map
        map = new Map(41, 21);
        map.generateMap();
        map.putEnemy();
        attachEnemyController();

        //Show Interface
        gameInterface.switchToMap(new KeyListener() {
          int key;

          @Override
          public void keyTyped(KeyEvent keyEvent) {
          }

          @Override
          public void keyPressed(KeyEvent keyEvent) {
            key = keyEvent.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
              if (map.inBounds(playerEntity.getPosition(Entity.LEFT))) {
                if (map.getMapCell(playerEntity.getPosition(Entity.LEFT)).getTerrain()
                    .isPassable()) {
                  playerEntity.move(Entity.LEFT);
                }
              }
              else {
                //pindah map
              }
            }
            else if (key == KeyEvent.VK_RIGHT) {
              if (map.inBounds(playerEntity.getPosition(Entity.RIGHT))) {
                if (map.getMapCell(playerEntity.getPosition(Entity.RIGHT)).getTerrain()
                    .isPassable()) {
                  playerEntity.move(Entity.RIGHT);
                }
              }
              else {
                //pindah map
              }
            }
            else if (key == KeyEvent.VK_UP) {
              if (map.inBounds(playerEntity.getPosition(Entity.UP))) {
                if (map.getMapCell(playerEntity.getPosition(Entity.UP)).getTerrain().isPassable()) {
                  playerEntity.move(Entity.UP);
                }
              }
              else {
                //pindah map
              }
            }
            else if (key == KeyEvent.VK_DOWN) {
              if (map.inBounds(playerEntity.getPosition(Entity.DOWN))) {
                if (map.getMapCell(playerEntity.getPosition(Entity.DOWN)).getTerrain()
                    .isPassable()) {
                  playerEntity.move(Entity.DOWN);
                }
              }
              else {
                //pindah map
              }
            }
          }

          @Override
          public void keyReleased(KeyEvent keyEvent) {
            key = -999;
          }
        }, map);
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

  public void attachEnemyController(){
    LinkedList<EnemyEntity> enemyList = map.getEnemyList();
    EnemyController enemyController;
    int i;
    for(i = 0; i<enemyList.size();i++){
      enemyController = new EnemyController(enemyList.get(i),map);
      enemyControllers.addLast(enemyController);
      enemyController.start();
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    Game game = new Game();
    game.MainMenu();
  }
}