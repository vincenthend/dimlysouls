package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import model.map.Map;
import view.GameInterface;

/**
 * Kelas GuiUpdateController mengatur kecepatan update GUI.
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
        gameInterface.updateMap(map);
        gameInterface.updateInterface();
      }
    });

    updateTimer.start();
  }

  public void battleUpdateTimer(){
    updateTimer = new Timer(UPDATE_SPEED, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        gameInterface.updateInterface();
      }
    });

    updateTimer.start();
  }

  public void stopTimer(){
    updateTimer.stop();
  }

  /**
   * Mengatur map yang digunakan saat update.
   * @param map map yang digunakan saat update
   */
  public void setMap(Map map){
    this.map = map;
  }
}
