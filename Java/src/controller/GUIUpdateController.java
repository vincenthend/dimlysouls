package controller;

import view.GameInterface;

/**
 * MASIH GATAU MAU PAKE INI APA GA.
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
