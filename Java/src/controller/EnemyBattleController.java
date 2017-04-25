package controller;

import java.util.Random;
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
    playerEntity = P;
    enemyEntity = E;
    isRunning = true;
  }

  /**
   * Menyerang thread jika HP > 0 tiap (600/speed) detik
   */
  @Override
  public void run() {
    Random rand = new Random();
    int attack;
    while (isRunning) {
      try {
        sleep(1000 / enemyEntity.getEnemy().getSpeed());
        attack = rand.nextInt(4)+1;
        if (attack == 1) {
          playerEntity.setCurrentHealth(
              playerEntity.getCurrentHealth() - (enemyEntity.getEnemy().getAttack() - playerEntity
                  .getPlayer().getDefense()));
        }
        else if (attack == 2) {

        }
        else if (attack == 3) {
          if (playerEntity.getStatus(0)) {
            playerEntity.setCurrentHealth(playerEntity.getCurrentHealth() - (
                (enemyEntity.getEnemy().getAttack() - playerEntity.getPlayer().getDefense()) * 2));
          }
          else {
            playerEntity.setCurrentHealth(
                playerEntity.getCurrentHealth() - (enemyEntity.getEnemy().getAttack() - playerEntity
                    .getPlayer().getDefense()));
          }
        }
        else if (attack == 4) {
          //enemyEntity.getEnemy().special();
        }
        if(playerEntity.getCurrentHealth() <= 0 || enemyEntity.getCurrentHealth() <= 0){
          isRunning = false;
        }
      } catch (InterruptedException e) {
      }
    }
  }

  public void kill() {
    isRunning = false;
  }
}