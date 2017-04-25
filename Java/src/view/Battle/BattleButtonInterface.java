package view.Battle;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.entity.PlayerEntity;

public class BattleButtonInterface extends JPanel {
  private PlayerEntity playerEntity;

  public BattleButtonInterface(PlayerEntity playerEntity, ActionListener buttonSel){
    setLayout(new GridLayout(2,2));
    BattleButton battleButton = new BattleButton(0, "Attack");
    battleButton.addActionListener(buttonSel);
    add(battleButton);
    battleButton = new BattleButton(1, "Guard");
    battleButton.addActionListener(buttonSel);
    add(battleButton);
    battleButton = new BattleButton(2, "Stab");
    battleButton.addActionListener(buttonSel);
    add(battleButton);
    battleButton = new BattleButton(3, "Special");
    battleButton.addActionListener(buttonSel);
    add(battleButton);
  }
}
