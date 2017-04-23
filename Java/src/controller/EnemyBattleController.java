package controller;

import model.entity.EnemyEntity;
import model.entity.PlayerEntity;

/**
 *
 */
public class EnemyBattleController extends Thread {

  private PlayerEntity playerEntity;
  private EnemyEntity enemyEntity;
  private boolean isRunning;


  /**
   *
   * @param P
   * @param E
   */
  public EnemyBattleController(PlayerEntity P, EnemyEntity E) {

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