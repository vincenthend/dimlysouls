package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.entity.Entity;
import model.entity.PlayerEntity;
import view.GameInterface;

public class PlayerController implements KeyListener {

  private PlayerEntity playerEntity;
  private GameInterface gameInterface;
  private int key;

  public PlayerController(PlayerEntity playerEntity, GameInterface gameInterface){
    this.playerEntity = playerEntity;
    this.gameInterface = gameInterface;
  }

  @Override
  public void keyTyped(KeyEvent keyEvent) {
  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {
    key = keyEvent.getKeyCode();
    if (key == KeyEvent.VK_LEFT) {
      playerEntity.move(Entity.LEFT);
    }
    else if (key == KeyEvent.VK_RIGHT) {
      playerEntity.move(Entity.RIGHT);
    }
    else if (key == KeyEvent.VK_UP) {
      playerEntity.move(Entity.UP);
    }
    else if (key == KeyEvent.VK_DOWN) {
      playerEntity.move(Entity.DOWN);
    }
    gameInterface.updateInterface();
  }

  @Override
  public void keyReleased(KeyEvent keyEvent) {
    key = -999;
  }
}
