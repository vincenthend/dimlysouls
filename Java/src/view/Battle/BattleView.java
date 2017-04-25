package view.Battle;

import java.awt.Color;
import javax.swing.JPanel;
import model.entity.EnemyEntity;
import model.entity.PlayerEntity;

public class BattleView extends JPanel {
  private PlayerEntity playerEntity;
  private EnemyEntity enemyEntity;

  public BattleView(PlayerEntity player, EnemyEntity enemy){
    playerEntity = player;
    enemyEntity = enemy;
    setBackground(Color.BLACK);
  }
}
