import controller.GameController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.GameInterface;

public class Game {
  private GameInterface gameInterface;
  private GameController gameController;

  /**
   * Konstruktor kelas game
   */
  public Game() {
    gameInterface = new GameInterface();
  }

  /**
   * Menampilkan Main Menu
   */
  public void MainMenu() {
    gameInterface.switchToMainMenu(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        gameController = new GameController(gameInterface);
        gameController.newGame();
      }
    });
    gameInterface.updateInterface();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    final Game game = new Game();
    game.MainMenu();
  }
}