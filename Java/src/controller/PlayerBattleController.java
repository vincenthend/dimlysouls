package controller;

import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import view.Battle.BattleButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerBattleController implements ActionListener {
  private PlayerEntity playerEntity;
  private EnemyEntity enemyEntity;

  public PlayerBattleController(PlayerEntity p, EnemyEntity e) {
    playerEntity = p;
    enemyEntity = e;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    BattleButton temp = (BattleButton) e.getSource();

    int atkId = temp.getAtkId();
    if (atkId == 0) {
      enemyEntity.setCurrentHealth(
              enemyEntity.getCurrentHealth() - calculateDamage(1));
      System.out.println(atkId);
    }
    else if (atkId == 1) {
      playerEntity.setStatus(0, 1);
      System.out.println(atkId);
    }
    else if (atkId == 2) {
      if (enemyEntity.getStatus(0)) {
        enemyEntity.setCurrentHealth(
                enemyEntity.getCurrentHealth() - calculateDamage(2));
      }
      else {
        enemyEntity.setCurrentHealth(
                enemyEntity.getCurrentHealth() - calculateDamage(1));
      }
      System.out.println(atkId);
    }
    else if (atkId == 3) {
      //p.getPlayer().special();
      System.out.println(atkId);
    }
  }
  private int calculateDamage(int multiplier){
    int temp;
    temp = (playerEntity.getPlayer().getAttack() - enemyEntity.getEnemy().getDefense()) * multiplier;
    if (temp < 0){
      temp = 0;
    }
    return temp;
  }
}