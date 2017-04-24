package controller;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.entity.Entity;
import model.entity.PlayerEntity;
import model.map.Map;
import model.map.TransferPoint;
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
  public synchronized void keyReleased(KeyEvent keyEvent) {
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

    TransferPoint tp;
    TransferPoint tpTemp;
    Map tempMap;
    int x;
    int y;
    if (move != -1) {
      if (map.inBounds(playerEntity.getPosition(move))) {
        if (map.getMapCell(playerEntity.getPosition(move)).getTerrain().isPassable()) {
          map.getMapCell(playerEntity.getPosition(move)).setEntity(playerEntity);
          map.getMapCell(playerEntity.getPosition()).setEntity(null);
          playerEntity.move(move);
        }
      }
      else {
        //Find exit point
          tp = map.getTransferPoint(playerEntity.getPosition());
          if (tp.getNextMap() == null) {
            playerEntity.move(move);
            x = (playerEntity.getPosition().x + map.getWidth()) % map.getWidth();
            y = (playerEntity.getPosition().y + map.getHeight()) % map.getHeight();
            playerEntity.setPosition(new Point(x, y));
            tp.setEntrancePoint(new Point(x, y));

            tempMap = new Map(map.getWidth(), map.getHeight());
            tempMap.generateMap(tp.getEntrancePoint());
            tp.setNextMap(tempMap);

            tpTemp = tempMap.getTransferPoint(tp.getEntrancePoint());
            tpTemp.setNextMap(map);
            tpTemp.setEntrancePoint(tp.getExitPoint());
          }
          map.getMapCell(tp.getExitPoint()).setEntity(null);
          map = tp.getNextMap();
          map.getMapCell(tp.getEntrancePoint()).setEntity(playerEntity);
          playerEntity.setPosition(tp.getEntrancePoint());
      }
      gameInterface.updateMap(map);
      gameInterface.updateInterface();
    }
  }
}
