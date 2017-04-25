package controller;

import controller.listener.EncounterListener;
import controller.listener.MapChangeListener;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.entity.Entity;
import model.entity.PlayerEntity;
import model.map.Cell;
import model.map.Map;
import model.map.TransferPoint;
import view.GameInterface;

/**
 * Kelas PlayerController, mengontrol pergerakan player.
 */
public class PlayerController implements KeyListener {
  private PlayerEntity playerEntity;
  private Map map;
  private MapChangeListener mapChange;
  private EncounterListener encounterListener;

  /**
   * Konstruktor kelas PlayerController.
   *
   * @param playerEntity player yang terlibat
   * @param gameInterface gameInterface yang digunakan
   * @param map map yang digunakan
   */
  public PlayerController(PlayerEntity playerEntity, GameInterface gameInterface, Map map) {
    this.playerEntity = playerEntity;
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
    int key = keyEvent.getKeyCode();

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
    Cell tempCell;
    int x;
    int y;
    if (move != -1) {
      if (map.inBounds(playerEntity.getPosition(move))) {
        tempCell = map.getMapCell(playerEntity.getPosition(move));
        if (tempCell.getTerrain().isPassable()) {
          //encounter is found
          if (tempCell.getEntity() != null) {
            encounterListener.EncounterFound(tempCell.getEntity().getEntityId());
          }
          map.getMapCell(playerEntity.getPosition(move)).setEntity(playerEntity);
          map.getMapCell(playerEntity.getPosition()).setEntity(null);
          playerEntity.move(move);
        }
      }
      else {
        //Player goes to the next map, count exit point and change map
        tp = map.getTransferPoint(playerEntity.getPosition());
        if (tp.getNextMap() == null) {
          playerEntity.move(move);
          x = (playerEntity.getPosition().x + map.getWidth()) % map.getWidth();
          y = (playerEntity.getPosition().y + map.getHeight()) % map.getHeight();
          playerEntity.setPosition(new Point(x, y));
          tp.setEntrancePoint(new Point(x, y));

          //Generate map
          tempMap = new Map(map.getWidth(), map.getHeight());
          tempMap.generateMap(tp.getEntrancePoint());
          tempMap.putEnemy();
          tp.setNextMap(tempMap);

          tpTemp = tempMap.getTransferPoint(tp.getEntrancePoint());
          tpTemp.setNextMap(map);
          tpTemp.setEntrancePoint(tp.getExitPoint());
        }
        map.getMapCell(tp.getExitPoint()).setEntity(null);
        map = tp.getNextMap();
        map.getMapCell(tp.getEntrancePoint()).setEntity(playerEntity);
        mapChange.mapChanged(map);
        playerEntity.setPosition(tp.getEntrancePoint());
      }
    }
  }

  public void setMapChange(MapChangeListener mapChange) {
    this.mapChange = mapChange;
  }

  public void setEncounterListener(EncounterListener encounterListener) {
    this.encounterListener = encounterListener;
  }
}
