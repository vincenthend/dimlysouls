package view.Battle;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import view.EnemyStatsInterface;
import view.StatsInterface;

public class BattleInterface extends JPanel {
  private BattleButtonInterface buttonInterface;
  private BattleView battleView;
  private StatsInterface statsInterface;
  private EnemyStatsInterface enemyStatsInterface;
  private PlayerEntity playerEntity;
  private EnemyEntity enemyEntity;

  public BattleInterface(PlayerEntity playerEntity, EnemyEntity enemyEntity,
      ActionListener buttonSel) {

    setLayout(new GridBagLayout());
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.gridheight = 8;
    gridBagConstraints.weightx = 1;
    gridBagConstraints.anchor = GridBagConstraints.WEST;
    gridBagConstraints.insets = new Insets(0,0,0,10);
    enemyStatsInterface = new EnemyStatsInterface(enemyEntity);
    add(enemyStatsInterface, gridBagConstraints);

    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 5;
    gridBagConstraints.gridheight = 5;
    gridBagConstraints.weighty = 5;
    gridBagConstraints.weightx = 5;
    gridBagConstraints.fill = GridBagConstraints.BOTH;
    gridBagConstraints.anchor = GridBagConstraints.NORTH;
    gridBagConstraints.insets = new Insets(0,0,0,0);
    battleView = new BattleView(playerEntity, enemyEntity);
    add(battleView, gridBagConstraints);

    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.fill = GridBagConstraints.BOTH;
    gridBagConstraints.weighty = 1;
    gridBagConstraints.anchor = GridBagConstraints.SOUTH;
    gridBagConstraints.insets = new Insets(0,0,0,0);
    buttonInterface = new BattleButtonInterface(playerEntity, buttonSel);
    add(buttonInterface, gridBagConstraints);

    gridBagConstraints.gridx = 8;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.gridheight = 8;
    gridBagConstraints.weightx = 1;
    gridBagConstraints.anchor = GridBagConstraints.EAST;
    gridBagConstraints.insets = new Insets(0,10,0,0);
    statsInterface = new StatsInterface(playerEntity);
    add(statsInterface, gridBagConstraints);
  }

  public BattleButtonInterface getButtonInterface() {
    return buttonInterface;
  }

}
