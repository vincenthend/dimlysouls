package controller;

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
    PlayerBattleController PBC = new PlayerBattleController(playerEntity, enemyEntity);

    gameInterface.switchToBattle(PBC, enemyEntity);
    gameInterface.updateInterface();

    EnemyBattleController EBC = new EnemyBattleController(playerEntity, enemyEntity);
    //Run EBC & PBC Thread
    EBC.start();
    //Kill EBC Thread
    //EBC.kill();
  }
}
