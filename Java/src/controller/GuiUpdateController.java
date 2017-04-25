package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import model.map.Map;
import view.GameInterface;

public class GuiUpdateController {
  public final int UPDATE_SPEED = 17;
  private GameInterface gameInterface;
  private Map map;

  GuiUpdateController(GameInterface gameInterface, Map map) {
    this.map = map;
    this.gameInterface = gameInterface;
  }

  public void mapUpdateTimer() {
    Timer updateTimer = new Timer(UPDATE_SPEED, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        gameInterface.updateMap(map);
        gameInterface.updateInterface();
      }
    });

    updateTimer.start();
  }

  public void setMap(Map map){
    this.map = map;
  }
}
