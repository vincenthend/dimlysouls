package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
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
  public synchronized void run() {
    //Buat Listener
    PlayerBattleController PBC = new PlayerBattleController(playerEntity, enemyEntity);

    //Pindah ke battle view

    Timer timer = new Timer(500, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        gameInterface.switchToBattle(PBC, enemyEntity);
        gameInterface.updateInterface();
        if(enemyEntity.getCurrentHealth() <= 0){
          ((Timer)actionEvent.getSource()).stop();
          notifyAll();
        }
      }
    });

    timer.start();
    try {
      wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(gameInterface.getStatus());

    EnemyBattleController EBC = new EnemyBattleController(playerEntity, enemyEntity);
    //Run EBC & PBC Thread
    EBC.start();
    //Kill EBC Thread
    //EBC.kill();
  }
}
