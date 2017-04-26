package controller;

import java.util.Random;
import model.entity.EnemyEntity;
import model.entity.PlayerEntity;

/**
 * Kelas EnemyBattleController, mengatur aksi musuh pada saat battle.
 *
 * @author Mikhael Artur Darmakesuma / 13515099
 */
public class EnemyBattleController extends Thread {

  private PlayerEntity playerEntity;
  private EnemyEntity enemyEntity;
  private boolean isRunning;

  /**
   * Konstruktor kelas EnemyBattleController.
   *
   * @param p player yang terlibat
   * @param e musuh yang terlibat
   */
  public EnemyBattleController(PlayerEntity p, EnemyEntity e) {
    playerEntity = p;
    enemyEntity = e;
    isRunning = true;
  }

  /**
   * Menyerang thread jika HP > 0 tiap (600/speed) detik.
   */
  @Override
  public void run() {
    Random rand = new Random();
    int attack;
    while (isRunning) {
      try {
        sleep(1000 / enemyEntity.getEnemy().getSpeed());
        attack = rand.nextInt(4) + 1;
        if (attack == 1) {
          playerEntity.setCurrentHealth(playerEntity.getCurrentHealth() - calculateDamage(1));
        } else if (attack == 2) {
          enemyEntity.setStatus(0, 1);
        } else if (attack == 3) {
          if (playerEntity.getStatus(0)) {
            playerEntity.setCurrentHealth(playerEntity.getCurrentHealth() - calculateDamage(2));
          } else {
            playerEntity.setCurrentHealth(
                playerEntity.getCurrentHealth() - calculateDamage(1));
          }
        } else if (attack == 4) {
          //enemyEntity.getEnemy().special();
        }
        if (playerEntity.getCurrentHealth() <= 0 || enemyEntity.getCurrentHealth() <= 0) {
          isRunning = false;
        }
      } catch (InterruptedException e) {
        System.out.print("Intterupted");
      }
    }
  }

  /**
   * Mematikan EBC.
   */
  public void kill() {
    isRunning = false;
  }

  /**
   * Menghitung damage.
   *
   * @param multiplier pengali damage
   * @return nilai damage yang dihasilkan.
   */
  private int calculateDamage(int multiplier) {
    int temp =
        (enemyEntity.getEnemy().getAttack() - playerEntity.getPlayer().getDefense()) * multiplier;
    if (temp < 0) {
      temp = 0;
    }
    return temp;
  }
}