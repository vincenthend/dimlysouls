import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import model.map.Map;
import model.player.Player;
import view.GameInterface;

public class Game {

  private Player player;
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
      }
    };

    ActionListener loadGame = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Load Game Invoked");
        //Load game dari file
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