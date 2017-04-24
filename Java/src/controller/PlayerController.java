package controller;

import java.awt.event.KeyListener;
import model.entity.PlayerEntity;

public class PlayerController extends Thread {
  private PlayerEntity player;
  private KeyListener key;
  private boolean isRunning;

  public PlayerController(PlayerEntity player, KeyListener keyListener) {
    key = keyListener;
    this.player = player;
    isRunning = true;
  }

  @Override
  public void run() {
    while (isRunning) {
    }
    //wait for keystroke
    //jalan
  }

  public void kill() {
    isRunning = false;
  }
}
