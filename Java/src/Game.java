import controller.Controller;

public class Game {
  private Controller controller;

  /**
   * Konstruktor kelas game
   */
  public Game() {
    controller = new Controller();
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    final Game game = new Game();
  }
}