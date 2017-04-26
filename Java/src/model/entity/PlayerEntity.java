package model.entity;

import java.awt.Point;
import model.player.Player;

/**
 * Kelas PlayerEntity berisi player.
 *
 * @author Vincent Hendryanto H/ 13515089
 */
public final class PlayerEntity extends Entity {

  private Player player;
  private int currentHealth;
  private int[] status;

  /**
   * Konstruktor kelas PlayerEntity.
   *
   * @param x absis lokasi Player
   * @param y ordinat lokasi Player
   * @param player Player terkait
   */
  public PlayerEntity(int x, int y, Player player) {
    super(x, y, 0);

    this.player = player;
    currentHealth = player.getHealth();
    renderCode = "P";
    status = new int[5];
    int i;
    for (i = 0; i < 5; i++) {
      status[i] = 0;
    }
  }

  /**
   * Konstruktor kelas PlayerEntity.
   *
   * @param location lokasi Player
   * @param player player terkait
   */
  public PlayerEntity(Point location, Player player) {
    super(location, 0);

    this.player = player;
    currentHealth = player.getHealth();
    renderCode = "P";
    status = new int[5];
    int i;
    for (i = 0; i < 5; i++) {
      status[i] = 0;
    }
  }

  /**
   * Getter health player sekarang.
   *
   * @return nilai health player saat ini
   */
  public int getCurrentHealth() {
    return currentHealth;
  }

  /**
   * Setter nilai health player sekarang.
   *
   * @param h nilai health player
   */
  public void setCurrentHealth(int h) {
    currentHealth = h;
  }

  /**
   * Menghitung turn.
   */
  public void turn() {
    int i;
    for (i = 0; i < 5; i++) {
      if (status[i] > 0) {
        status[i] = status[i] - 1;
      }
    }
  }

  /**
   * Mengembalikan status player.
   *
   * @param n kode status player
   * @return nilai status kode
   */
  public boolean getStatus(int n) {
    return (status[n] > 0);
  }

  /**
   * Memasang status player.
   *
   * @param code kode status player
   * @param cond nilai kondisi status player
   */
  public void setStatus(int code, int cond) {
    status[code] = cond;
  }

  /**
   * Getter player terkait.
   *
   * @return player terkait
   */
  public Player getPlayer() {
    return player;
  }
}