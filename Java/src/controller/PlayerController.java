package controller;

import model.entity.Entity;
import model.entity.PlayerEntity;
import model.map.Cell;
import model.map.Map;
import model.map.TransferPoint;
import view.GameInterface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {

  private PlayerEntity playerEntity;
  private GameInterface gameInterface;
  private int key;
  private Map map;

  public PlayerController(PlayerEntity playerEntity, GameInterface gameInterface, Map map){
    this.playerEntity = playerEntity;
    this.gameInterface = gameInterface;
    this.map = map;
  }

  @Override
  public void keyTyped(KeyEvent keyEvent) {
  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {
    Cell tempCell;
    TransferPoint tempTP;
    key = keyEvent.getKeyCode();
    if (key == KeyEvent.VK_LEFT) {
      if (map.isInRange(playerEntity.getPosition(Entity.LEFT))){
        if (map.getMapCell(playerEntity.getPosition(Entity.LEFT)).getTerrain()
                .isPassable()) {
          tempCell = map.getMapCell(playerEntity.getPosition());
          tempCell.setEntity(null);
          tempCell = map.getMapCell(playerEntity.getPosition(Entity.LEFT));
          tempCell.setEntity(playerEntity);
          playerEntity.move(Entity.LEFT);
        }
      }
      else {
        tempCell = map.getMapCell(playerEntity.getPosition());
        tempCell.setEntity(null);
        tempTP = map.getTransferPoint(playerEntity.getPosition());
        playerEntity.setPosition(tempTP.getExitPoint());
        map = tempTP.getNextMap();
        tempCell = map.getMapCell(playerEntity.getPosition());
        tempCell.setEntity(playerEntity);
      }
    }
    else if (key == KeyEvent.VK_RIGHT) {
      if (map.isInRange(playerEntity.getPosition(Entity.RIGHT))){
        if (map.getMapCell(playerEntity.getPosition(Entity.RIGHT)).getTerrain()
                .isPassable()) {
          tempCell = map.getMapCell(playerEntity.getPosition());
          tempCell.setEntity(null);
          tempCell = map.getMapCell(playerEntity.getPosition(Entity.RIGHT));
          tempCell.setEntity(playerEntity);
          playerEntity.move(Entity.RIGHT);
        }
      }
      else {
        tempCell = map.getMapCell(playerEntity.getPosition());
        tempCell.setEntity(null);
        tempTP = map.getTransferPoint(playerEntity.getPosition());
        playerEntity.setPosition(tempTP.getExitPoint());
        map = tempTP.getNextMap();
        tempCell = map.getMapCell(playerEntity.getPosition());
        tempCell.setEntity(playerEntity);
      }
    }
    else if (key == KeyEvent.VK_UP) {
      if (map.isInRange(playerEntity.getPosition(Entity.UP))){
        if (map.getMapCell(playerEntity.getPosition(Entity.UP)).getTerrain()
                .isPassable()) {
          tempCell = map.getMapCell(playerEntity.getPosition());
          tempCell.setEntity(null);
          tempCell = map.getMapCell(playerEntity.getPosition(Entity.UP));
          tempCell.setEntity(playerEntity);
          playerEntity.move(Entity.UP);
        }
      }
      else {
        tempCell = map.getMapCell(playerEntity.getPosition());
        tempCell.setEntity(null);
        tempTP = map.getTransferPoint(playerEntity.getPosition());
        playerEntity.setPosition(tempTP.getExitPoint());
        map = tempTP.getNextMap();
        tempCell = map.getMapCell(playerEntity.getPosition());
        tempCell.setEntity(playerEntity);
      }
    }
    else if (key == KeyEvent.VK_DOWN) {
      if (map.isInRange(playerEntity.getPosition(Entity.DOWN))){
        if (map.getMapCell(playerEntity.getPosition(Entity.DOWN)).getTerrain()
                .isPassable()) {
          tempCell = map.getMapCell(playerEntity.getPosition());
          tempCell.setEntity(null);
          tempCell = map.getMapCell(playerEntity.getPosition(Entity.DOWN));
          tempCell.setEntity(playerEntity);
          playerEntity.move(Entity.DOWN);
        }
      }
      else {
        tempCell = map.getMapCell(playerEntity.getPosition());
        tempCell.setEntity(null);
        tempTP = map.getTransferPoint(playerEntity.getPosition());
        playerEntity.setPosition(tempTP.getExitPoint());
        map = tempTP.getNextMap();
        tempCell = map.getMapCell(playerEntity.getPosition());
        tempCell.setEntity(playerEntity);
      }
    }
    gameInterface.updateInterface();
  }

  @Override
  public void keyReleased(KeyEvent keyEvent) {
    key = -999;
  }
}
