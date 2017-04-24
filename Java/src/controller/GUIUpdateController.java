package controller;

import view.GameInterface;

/**
 * Created by vince on 24/04/2017.
 */
public class GUIUpdateController extends Thread {
  private GameInterface gui;

  public GUIUpdateController(GameInterface gui) {
    this.gui = gui;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(2500);
        gui.updateInterface();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
