import model.entity.PlayerEntity;
import model.map.Map;
import model.player.Player;
import model.player.Warrior;
import view.GameInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class Game {

  private Player player;
  private PlayerEntity playerEntity;
  private LinkedList<Map> mapList;
  private GameInterface gameInterface;

  /**
   * Default constructor
   */
  public Game() {
    gameInterface = new GameInterface();
  }

  public void MainMenu(){
    ActionListener newGame = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("New Game Invoked");
        //Pilih class
        player = new Warrior("Player");

        //Generate Map

        //Set Player
        playerEntity = new PlayerEntity(0, 0, player);
        gameInterface.setPlayer(playerEntity);

        //Show Interface
        gameInterface.switchToMap(new KeyListener() {
          int key;
          @Override
          public void keyTyped(KeyEvent keyEvent) {
          }

          @Override
          public void keyPressed(KeyEvent keyEvent) {
            key = keyEvent.getKeyCode();
            if (key == KeyEvent.VK_LEFT){
              //if kirinya bisa
              playerEntity.move(-1, 0);
            }
            else if (key == KeyEvent.VK_RIGHT){
              playerEntity.move(1, 0);
            }
            else if (key == KeyEvent.VK_UP){
              playerEntity.move(0, -1);
            }
            else if (key == KeyEvent.VK_DOWN){
              playerEntity.move(0, 1);
            }
          }

          @Override
          public void keyReleased(KeyEvent keyEvent) {
            key = -999;
          }
        }, null);
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

  public void Start(){
    //Nyalain PlayerController, EnemyController (buat tiap enemy) uhh liat di notepad aja :P
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    Game game = new Game();
    game.MainMenu();
  }

}