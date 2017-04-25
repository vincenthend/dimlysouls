package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.enemy.Enemy;
import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import model.player.Player;
import view.GameInterface;

/**
 *
 */
public class BattleController {
  private EnemyEntity e;
  private PlayerEntity p;
  private GameInterface g;

  /**
   * Konstruktor battle controller, dipanggil setiap melakukan battle
   *
   * @param enemy reference enemy yang terlibat battle
   * @param player reference player yang terlibat battle
   * @param gameInterface interface yang sedang berjalan
   */
  public BattleController(Enemy enemy, Player player, GameInterface gameInterface) {

  }

  /**
   * Memulai battle
   */
  public void startBattle() {
    //Deklarasi MouseListener
    ActionListener[] skillListener = new ActionListener[2];
    skillListener[0] = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        e.setCurrentHealth(
            e.getCurrentHealth() - (p.getPlayer().getAttack() - e.getEnemy().getDefense()));
        updateBattleView();
      }
    };
    skillListener[1] = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        p.setStatus(0, 1);
        updateBattleView();
      }
    };
    skillListener[3] = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        if (e.getStatus(0)) {
          e.setCurrentHealth(
              e.getCurrentHealth() - ((p.getPlayer().getAttack() - e.getEnemy().getDefense()) * 2));
        }
        else {
          e.setCurrentHealth(
              e.getCurrentHealth() - (p.getPlayer().getAttack() - e.getEnemy().getDefense()));
        }
        updateBattleView();
      }
    };
    skillListener[4] = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        //p.getPlayer().special();
        updateBattleView();
      }
    };

    //Deklarasi EnemyBattleController & PlayerBattleController
    EnemyBattleController EBC = new EnemyBattleController(p, e);
    PlayerBattleController PBC = new PlayerBattleController(p, e);
    //Set Battle GUI
    g.switchToBattle(skillListener, e);
    //Run EBC & PBC Thread
    EBC.start();
    PBC.start();

    //While not battle end
    boolean isBattling = true;
    while (isBattling) {
      //Button dipencet
      PBC.calculateDamage();
      updateBattleView();
    }
    EBC.kill();
    PBC.kill();
    //g.switchToMap();
    //Kill EBC & PBC Thread
  }

  /**
   * Memanggil method battleViewUpdate pada class gameInterface
   */
  public void updateBattleView() {
    g.battleViewUpdate(e);
  }
}
