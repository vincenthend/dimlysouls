package view.battle;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * Kelas BattleButtonInterface, tempat meletakkan BattleButton.
 */
public class BattleButtonInterface extends JPanel {

  private BattleButton[] battleButton;

  /**
   * Konstruktor kelas BattleButtonInterface.
   *
   * @param buttonSel ActionListener untuk menangkap tombol yang ditekan
   */
  public BattleButtonInterface(ActionListener buttonSel) {
    battleButton = new BattleButton[4];
    setLayout(new GridLayout(2, 2));
    battleButton[0] = new BattleButton(0, "Attack");
    battleButton[0].addActionListener(buttonSel);
    add(battleButton[0]);
    battleButton[1] = new BattleButton(1, "Guard");
    battleButton[1].addActionListener(buttonSel);
    add(battleButton[1]);
    battleButton[2] = new BattleButton(2, "Stab");
    battleButton[2].addActionListener(buttonSel);
    add(battleButton[2]);
    battleButton[3] = new BattleButton(3, "Special");
    battleButton[3].addActionListener(buttonSel);
    add(battleButton[3]);
  }

  /**
   * Mengembalikan array berisi tombol yang digunakan.
   * @return array battle button
   */
  public BattleButton[] getBattleButton() {
    return battleButton;
  }
}
