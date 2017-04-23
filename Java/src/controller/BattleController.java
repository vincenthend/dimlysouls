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
   * @param e reference enemy yang terlibat battle
   * @param p reference player yang terlibat battle
   * @param g interface yang sedang berjalan
   */
  public BattleController(Enemy e, Player p, GameInterface g) {

  }


  /**
   * Membuat thread EnemyBattleController, dan membuat battleInterface
   * dengan memanggil method createBattleInterface pada gameInterface
   * kemudian mematikan thread EnemyBattleController setelah battle berakhir
   */
  public void startBattle() {
    g.createBattleInterface(p, e);
    EnemyBattleController(e);
  }

  /**
   * Memanggil method battleViewUpdate pada class gameInterface
   */
  public void updateBattleView() {

  }
}
