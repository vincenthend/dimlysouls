package view.battle;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * Kelas BattleButtonInterface, tempat meletakkan BattleButton.
 */
public class BattleButtonInterface extends JPanel {
  /**
   * Konstruktor kelas BattleButtonInterface.
   *
   * @param buttonSel ActionListener untuk menangkap tombol yang ditekan
   */
  public BattleButtonInterface(ActionListener buttonSel) {
    setLayout(new GridLayout(2, 2));
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
