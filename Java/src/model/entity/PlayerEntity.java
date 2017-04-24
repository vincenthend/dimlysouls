package model.entity;

import model.player.Player;

import java.awt.*;

/**
 *
 */
public final class PlayerEntity extends Entity {

  private Player player;
  private int currentHealth;
  private int [] status;

  /**
   * Default constructor
   */
  public PlayerEntity(int x, int y, Player player) {
    super(x, y,0);
    int i;
    this.player = player;
    currentHealth = player.getHealth();
    renderCode = "P";
    status = new int [5];
    for (i = 0; i < 5; i++){
      status [i] = 0;
    }
  }

  public PlayerEntity(Point location, Player player) {
    super(location,0);
    int i;
    this.player = player;
    currentHealth = player.getHealth();
    renderCode = "P";
    status = new int [5];
    for (i = 0; i < 5; i++){
      status [i] = 0;
    }
  }

  public int getCurrentHealth() {
    return currentHealth;
  }
  public void setCurrentHealth(int h) {
    currentHealth = h;
  }
  public void turn(){
    int i;
    for (i = 0; i < 5; i++){
      if (status [i] > 0){
        status [i] = status [i] - 1;
      }
    }
  }
  public boolean getStatus(int n){
    return (status[n] > 0);
  }
  public void setStatus(int n, int t){
    status[n] = t;
  }

  public Player getPlayer() {
    return player;
  }
}