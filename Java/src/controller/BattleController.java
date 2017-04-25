package controller;

import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import view.Battle.BattleButton;
import view.Battle.BattleInterface;
import view.GameInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class BattleController {
  private EnemyEntity enemyEntity;
  private PlayerEntity playerEntity;
  private GameInterface gameInterface;

  /**
   * Konstruktor battle controller, dipanggil setiap melakukan battle
   *
   * @param enemyEntity reference enemy yang terlibat battle
   * @param playerEntity reference player yang terlibat battle
   * @param gameInterface interface yang sedang berjalan
   */
  public BattleController(EnemyEntity enemyEntity, PlayerEntity playerEntity, GameInterface gameInterface) {
    this.enemyEntity = enemyEntity;
    this.playerEntity = playerEntity;
    this.gameInterface = gameInterface;
  }

  /**
   * Memulai battle
   */
  public void startBattle() {
    //Deklarasi MouseListener
    BattleInterface battleInterface = new BattleInterface(playerEntity, enemyEntity, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        BattleButton temp = (BattleButton) e.getSource();

        int atkId = temp.getAtkId();
        if (atkId == 0) {
          enemyEntity.setCurrentHealth(
                  enemyEntity.getCurrentHealth() - (playerEntity.getPlayer().getAttack() - enemyEntity.getEnemy().getDefense()));
          updateBattleView();
          System.out.println(atkId);
        }
        else if (atkId == 1) {
          playerEntity.setStatus(0, 1);
          updateBattleView();
          System.out.println(atkId);
        }
        else if (atkId == 2) {
          if (enemyEntity.getStatus(0)) {
            enemyEntity.setCurrentHealth(
                    enemyEntity.getCurrentHealth() - ((playerEntity.getPlayer().getAttack() - enemyEntity.getEnemy().getDefense()) * 2));
          }
          else {
            enemyEntity.setCurrentHealth(
                    enemyEntity.getCurrentHealth() - (playerEntity.getPlayer().getAttack() - enemyEntity.getEnemy().getDefense()));
          }
          updateBattleView();
          System.out.println(atkId);
        }
        else if (atkId == 3) {
          //p.getPlayer().special();
          updateBattleView();
          System.out.println(atkId);
        }
      }
    });
    //Deklarasi EnemyBattleController & PlayerBattleController
    EnemyBattleController EBC = new EnemyBattleController(playerEntity, enemyEntity);
    PlayerBattleController PBC = new PlayerBattleController(playerEntity, enemyEntity);
    //Set Battle GUI
    //Run EBC & PBC Thread
    EBC.start();
    PBC.start();

    //While not battle end
    boolean isBattling = true;
    while (isBattling) {
      updateBattleView();
    }
    EBC.kill();
    PBC.kill();
    //gameInterface.switchToMap();
    //Kill EBC & PBC Thread
  }

  /**
   * Memanggil method battleViewUpdate pada class gameInterface
   */
  public void updateBattleView() {
    gameInterface.battleViewUpdate(enemyEntity);
  }
  public int calculateDamage(){return 0;}
}
