package view.Battle;

import javax.swing.JButton;

public class BattleButton extends JButton {
  private int atkId;

  public BattleButton(int atkId, String atkName){
    this.atkId = atkId;
    setText(atkName);
  }

  public int getAtkId(){
    return atkId;
  }

}
