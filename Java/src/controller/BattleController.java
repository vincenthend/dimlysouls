package controller;

import model.enemy.Enemy;
import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import model.player.Player;
import view.GameInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 */
public class BattleController {

  private EnemyEntity e;
  private PlayerEntity p;
  private GameInterface g;


  /**
   * Konstruktor battle controller, dipanggil setiap melakukan battle
   * @param enemy reference enemy yang terlibat battle
   * @param player reference player yang terlibat battle
   * @param gameInterface interface yang sedang berjalan
   */
  public BattleController(Enemy enemy, Player player, GameInterface gameInterface) {

  }


  /**
   *
   */
  public void startBattle() {
    //Deklarasi MouseListener
    ActionListener Mouse = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {

      }
    }
    };

    //Deklarasi EnemyBattleController & PlayerBattleController
    EnemyBattleController EBC = new EnemyBattleController(p, e);
    EBC.start();
    PlayerBattleController PBC = new PlayerBattleController(p, e);

    //Set Battle GUI

    g.
    //Run EBC & PBC Thread
    //While not battle end
      //Wait for mouse click
      //On mouse click, update GUI

    //Kill EBC & PBC Thread
  }

  /**
   * Memanggil method battleViewUpdate pada class gameInterface
   */
  public void updateBattleView() {

  }
}
