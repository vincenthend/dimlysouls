package controller;

import model.enemy.Enemy;
import model.player.Player;

/**
 *
 */
public class EnemyBattleController extends Thread {

  private Player playerEntity;
  private Enemy enemyEntity;
  private boolean isRunning;


  /**
   *
   * @param P
   * @param E
   */
  public EnemyBattleController(Player P, Enemy E) {

  }


  /**
   * Menyerang thread jika HP > 0 tiap (600/speed) detik
   */
  @Override
  public void run() {
    //While isRunning
    //Sleep for ... seconds
    //Attack
  }


}