package controller;

import model.entity.PlayerEntity;
import model.player.Player;

import java.awt.event.KeyListener;

public class PlayerController extends Thread {
  private PlayerEntity player;
  private KeyListener key;
  private boolean isRunning;

  public PlayerController(Player player, KeyListener keyListener) {

  }

  @Override
  public void run() {
    //while isrunning
    //wait for keystroke
      //jalan
  }
  public void kill(){
    isRunning = false;
  }
}
