package controller;

import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import view.GameInterface;
import view.battle.BattleButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
   * @param g interface yang digunakan
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
      int selfDamage = 0;
      int enemyDamage = 0;
      int [] selfStatus = new int [5];
      int [] enemyStatus = new int [5];
      playerEntity.getPlayer().special(selfDamage, enemyDamage, selfStatus, enemyStatus);
      playerEntity.setCurrentHealth(playerEntity.getCurrentHealth() - selfDamage);
      enemyEntity.setCurrentHealth(enemyEntity.getCurrentHealth() - enemyDamage);
    }
    playerEntity.turn();
    disableButton();
    Timer t = new Timer(10000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        enableButton();
      }
    });
    t.setRepeats(false);
    t.setInitialDelay(10000);
  }

  private void disableButton() {
    BattleButton[] battleButtons = gameInterface.getBattleInterface().getButtonInterface()
        .getBattleButton();

    battleButtons[0].setEnabled(false);
    battleButtons[1].setEnabled(false);
    battleButtons[2].setEnabled(false);
    battleButtons[3].setEnabled(false);
  }

  private void enableButton() {
    BattleButton[] battleButtons = gameInterface.getBattleInterface().getButtonInterface()
        .getBattleButton();

    battleButtons[0].setEnabled(true);
    battleButtons[1].setEnabled(true);
    battleButtons[2].setEnabled(true);
    battleButtons[3].setEnabled(true);
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