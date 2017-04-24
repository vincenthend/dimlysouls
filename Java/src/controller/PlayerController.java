package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.entity.Entity;
import model.entity.PlayerEntity;
import model.map.Map;
import view.GameInterface;

public class PlayerController implements KeyListener {
  private PlayerEntity playerEntity;
  private GameInterface gameInterface;
  private int key;
  private Map map;

  public PlayerController(PlayerEntity playerEntity, GameInterface gameInterface, Map map) {
    this.playerEntity = playerEntity;
    this.gameInterface = gameInterface;
    this.map = map;
  }

  @Override
  public void keyTyped(KeyEvent keyEvent) {
  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {

  }

  @Override
  public void keyReleased(KeyEvent keyEvent) {
    int move = -1;

    key = keyEvent.getKeyCode();
    if (key == KeyEvent.VK_LEFT) {
      move = Entity.LEFT;
    }
    else if (key == KeyEvent.VK_RIGHT) {
      move = Entity.RIGHT;
    }
    if (key == KeyEvent.VK_UP) {
      move = Entity.UP;
    }
    if (key == KeyEvent.VK_DOWN) {
      move = Entity.DOWN;
    }

    if (move != -1) {
      if (map.inBounds(playerEntity.getPosition(move))) {
        if (map.getMapCell(playerEntity.getPosition(move)).getTerrain().isPassable()) {
          map.getMapCell(playerEntity.getPosition(move)).setEntity(playerEntity);
          map.getMapCell(playerEntity.getPosition()).setEntity(null);
          playerEntity.move(move);
        }
      }
      else {
        //pindah map
      }
      System.out.println(playerEntity.getPosition());
      gameInterface.updateMap(map);
      gameInterface.updateInterface();
    }
  }
}
