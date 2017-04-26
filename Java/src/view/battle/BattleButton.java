package view.battle;

import javax.swing.JButton;

/**
 * Kelas BattleButton, merupakan turunan dari JButton.
 * Digunakan untuk membuat button yang menandai attack player.
 */
public class BattleButton extends JButton {

  private int atkId;

  /**
   * Konstruktor kelas BattleButton.
   *
   * @param atkId ID Tombol
   * @param atkName Nama Tombol
   */
  public BattleButton(int atkId, String atkName) {
    this.atkId = atkId;
    setText(atkName);
  }

  /**
   * Getter untuk ID Tombol.
   *
   * @return ID Tombol
   */
  public int getAtkId() {
    return atkId;
  }
}
