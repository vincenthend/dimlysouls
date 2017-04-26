package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import view.GameInterface;
import view.battle.BattleButton;

/**
 * Kelas PlayerBattleController, menerima aksi player saat battle.
 */
public class PlayerBattleController implements ActionListener {

  private GameInterface gameInterface;
  private PlayerEntity playerEntity;
  private EnemyEntity enemyEntity;

  /**
   * Konstruktor kelas PlayerBattleController.
   *
   * @param p player yang terlibat
   * @param e musuh yang terlibat
   */
  public PlayerBattleController(PlayerEntity p, EnemyEntity e, GameInterface g) {
    playerEntity = p;
    enemyEntity = e;
    gameInterface = g;
  }

  /**
   * Aksi yang dilakukan saat menekan tombol attack.
   *
   * @param e event yang dilakukan
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    BattleButton temp = (BattleButton) e.getSource();

    int atkId = temp.getAtkId();
    if (atkId == 0) {
      enemyEntity.setCurrentHealth(
          enemyEntity.getCurrentHealth() - calculateDamage(1));
    } else if (atkId == 1) {
      playerEntity.setStatus(0, 1);
    } else if (atkId == 2) {
      if (enemyEntity.getStatus(0)) {
        enemyEntity.setCurrentHealth(
            enemyEntity.getCurrentHealth() - calculateDamage(2));
      } else {
        enemyEntity.setCurrentHealth(
            enemyEntity.getCurrentHealth() - calculateDamage(1));
      }
    } else if (atkId == 3) {
      //p.getPlayer().special();
    }
    /*disableButton();
    Timer t = new Timer( new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        enableButton();
      }
    });//ANGKA 10 diganti waktu tunggu
    // Buat Timer nunggu dulu baru launch
    t.setInitialDelay(1000);*/
  }

  private void disableButton() {
    gameInterface.getBattleInterface().getButtonInterface().setVisible(false);
  }

  private void enableButton(){
    gameInterface.getBattleInterface().getButtonInterface().setVisible(true);
  }

  /**
   * Menghitung damage yang dihasilkan.
   *
   * @param multiplier pengali damage
   * @return jumlah damage
   */
  private int calculateDamage(int multiplier) {
    int temp;
    temp =
        (playerEntity.getPlayer().getAttack() - enemyEntity.getEnemy().getDefense()) * multiplier;
    if (temp < 0) {
      temp = 0;
    }
    return temp;
  }
}