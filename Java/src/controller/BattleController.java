package controller;

import controller.listener.BattleListener;
import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import view.GameInterface;

/**
 *
 */
public class BattleController extends Thread {
  private EnemyEntity enemyEntity;
  private PlayerEntity playerEntity;
  private GameInterface gameInterface;
  private BattleListener battleListener;

  /**
   * Konstruktor battle controller, dipanggil setiap melakukan battle.
   *
   * @param enemyEntity reference enemy yang terlibat battle
   * @param playerEntity reference player yang terlibat battle
   * @param gameInterface interface yang sedang berjalan
   */
  public BattleController(EnemyEntity enemyEntity, PlayerEntity playerEntity,
                          GameInterface gameInterface) {
    this.playerEntity = playerEntity;
    this.enemyEntity = enemyEntity;
    this.gameInterface = gameInterface;


  }

  /**
   * Memulai battle.
   */
  public void run() {
    //Buat Listener
    EnemyBattleController EBC = new EnemyBattleController(playerEntity, enemyEntity);

    //Run EBC & PBC Thread
    EBC.start();
    while (enemyEntity.getCurrentHealth() > 0) {
      System.out.println();
    }
    battleListener.onBattleEnd();
  }

  public void setBattleListener(BattleListener battleListener) {
    this.battleListener = battleListener;
  }
}
