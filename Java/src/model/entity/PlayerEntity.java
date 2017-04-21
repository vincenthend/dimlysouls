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
  public PlayerEntity() {
  }

  public int getCurrentHealth() {
    return currentHealth;
  }
}