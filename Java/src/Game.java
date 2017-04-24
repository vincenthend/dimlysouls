import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
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
  private LinkedList<Map> mapList;
  private GameInterface gameInterface;

  /**
   * Konstruktor kelas game
   */
  public Game() {
    gameInterface = new GameInterface();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    Game game = new Game();
    game.MainMenu();
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
        System.out.println(name);
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
        System.out.println(playerClass);

        //Generate Map

        //Set Player
        playerEntity = new PlayerEntity(0, 0, player);
        gameInterface.setPlayer(playerEntity);

        //Show Interface
        Map tempMap = new Map(41, 21);
        tempMap.generateMap();

        gameInterface.switchToMap(new KeyListener() {
          int key;

          @Override
          public void keyTyped(KeyEvent keyEvent) {
          }

          @Override
          public void keyPressed(KeyEvent keyEvent) {
            key = keyEvent.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
              //if kirinya bisa
              playerEntity.move(Entity.LEFT);
            }
            else if (key == KeyEvent.VK_RIGHT) {
              playerEntity.move(Entity.RIGHT);
            }
            else if (key == KeyEvent.VK_UP) {
              playerEntity.move(Entity.UP);
            }
            else if (key == KeyEvent.VK_DOWN) {
              playerEntity.move(Entity.DOWN);
            }
          }

          @Override
          public void keyReleased(KeyEvent keyEvent) {
            key = -999;
          }
        }, tempMap);
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

  public void Start() {
    //Nyalain PlayerController, EnemyController (buat tiap enemy) uhh liat di notepad aja :P
  }
}