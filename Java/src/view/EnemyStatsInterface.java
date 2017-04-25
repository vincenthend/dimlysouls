package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.enemy.Enemy;
import model.entity.EnemyEntity;

/**
 * Class EnemyStatsInterface menampilkan stats dari enemy.
 */
public class EnemyStatsInterface extends JPanel {
  private EnemyEntity enemyEntity;

  public EnemyStatsInterface(EnemyEntity enemy) {
    enemyEntity = enemy;

    setLayout(new GridBagLayout());
    updateStats();
  }

  public void updateStats() {
    removeAll();
    Enemy enemy = enemyEntity.getEnemy();

    GridBagConstraints label = new GridBagConstraints();
    label.gridx = 0;
    label.gridy = 0;
    label.gridwidth = 3;
    label.weightx = 2;
    label.insets = new Insets(0, 10, 0, 0);
    label.fill = GridBagConstraints.HORIZONTAL;

    GridBagConstraints stats = new GridBagConstraints();
    stats.gridx = 3;
    stats.gridy = 0;
    stats.gridwidth = 1;
    stats.weightx = 0.5;
    stats.insets = new Insets(0, 20, 0, 0);
    stats.fill = GridBagConstraints.HORIZONTAL;

    add(new JLabel("Name"), label);
    label.gridy++;
    add(new JLabel("HP"), label);
    label.gridy++;
    add(new JLabel("ATK"), label);
    label.gridy++;
    add(new JLabel("DEF"), label);
    label.gridy++;

    add(new JLabel(enemy.getClass().getSimpleName()), stats);
    stats.gridy++;
    add(new JLabel(
            Integer.toString(enemyEntity.getCurrentHealth()) + "/" + Integer
                .toString(enemy.getHealth())),
        stats);
    stats.gridy++;
    add(new JLabel(Integer.toString(enemy.getAttack())), stats);
    stats.gridy++;
    add(new JLabel(Integer.toString(enemy.getDefense())), stats);
    stats.gridy++;
  }
}
