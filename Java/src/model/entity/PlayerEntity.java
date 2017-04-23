package model.entity;

import model.player.Player;

/**
 *
 */
public final class PlayerEntity extends Entity {

  private Player player;
  private int currentHealth;

  /**
   * Default constructor
   */
  public PlayerEntity(int x, int y, Player player) {
    super(x, y);
    this.player = player;
    currentHealth = player.getHealth();
    renderCode = "P";
  }

  public void move(int deltaX, int deltaY) {
    locX += deltaX;
    locX += deltaY;
  }

  public int getCurrentHealth() {
    return currentHealth;
  }

  public Player getPlayer() {
    return player;
  }
}