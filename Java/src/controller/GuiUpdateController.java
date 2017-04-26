package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import model.map.Map;
import view.GameInterface;

/**
 * Kelas GuiUpdateController mengatur kecepatan update GUI.
 *
 * @author Mikhael Artur Darmakesuma / 13515099
 */
public class GuiUpdateController {
  public static final int FPS = 60;
  public static final int UPDATE_SPEED = 1000 / FPS;
  private GameInterface gameInterface;
  private Map map;
  //Timers
  private Timer updateTimer;

  /**
   * Konstruktor kelas GuiUpdateController.
   *
   * @param gameInterface gameInterface yang diupdate
   * @param map map yang digunakan sekarang
   */
  GuiUpdateController(GameInterface gameInterface, Map map) {
    this.map = map;
    this.gameInterface = gameInterface;
  }

  /**
   * Melakukan update terhadap interface yang memiliki map.
   */
  public void mapUpdateTimer() {
    updateTimer = new Timer(UPDATE_SPEED, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        if (gameInterface.getStatus() == GameInterface.MAP) {
          gameInterface.updateMap(map);
        }
        gameInterface.updateInterface();
      }
    });

    updateTimer.start();
  }

  /**
   * Melakukan update terhadap layar battle.
   */
  public void battleUpdateTimer() {
    updateTimer = new Timer(25, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        if (gameInterface.getStatus() == GameInterface.BATTLE) {
          gameInterface.updateBattle();
        }
        gameInterface.updateInterface();
      }
    });

    updateTimer.start();
  }

  /**
   * Menghentikan update yang berjalan.
   */
  public void stopTimer() {
    updateTimer.stop();
  }

  /**
   * Mengatur map yang digunakan saat update.
   *
   * @param map map yang digunakan saat update
   */
  public void setMap(Map map) {
    this.map = map;
  }
}
