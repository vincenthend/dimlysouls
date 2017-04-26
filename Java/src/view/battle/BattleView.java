package view.battle;

import java.awt.Color;
import javax.swing.JPanel;
import model.entity.EnemyEntity;
import model.entity.PlayerEntity;

/**
 * Kelas BattleView, berisi layar tempat musuh diletakkan.
 */
public class BattleView extends JPanel {
  private PlayerEntity playerEntity;
  private EnemyEntity enemyEntity;

  /**
   * Konstruktor kelas BattleView.
   *
   * @param player player yang terlibat
   * @param enemy musuh yang terlibat
   */
  public BattleView(PlayerEntity player, EnemyEntity enemy) {
    playerEntity = player;
    enemyEntity = enemy;
    setBackground(Color.BLACK);
  }
}
