package controller;

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

    //Deklarasi EnemyBattleController & PlayerBattleController

    //Set Battle GUI

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
