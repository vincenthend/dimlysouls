package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.map.Map;

public class MapInterface extends JPanel {

  private Map map;

  public MapInterface(Map map) {
    this.map = map;
    setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.gridy = 0;
    constraints.insets = new Insets(2,4,2,4);

    int i;
    int j;
    for(i = 0; i<map.getHeight(); i++){
      constraints.gridy = i;
      for(j = 0; j<map.getWidth(); j++){
        constraints.gridx = j;
        add(new JLabel(map.getMapCell(j,i).getEntity().getRenderCode()),constraints);
      }
    }

  }

  public void setMap(Map map) {
    this.map = map;
    setLayout(new GridLayout(map.getWidth(), map.getHeight()));

    int i;
    int j;
    for(i = 0; i<map.getHeight(); i++){
      for(j = 0; j<map.getWidth(); j++){
        add(new JLabel(map.getMapCell(i,j).getEntity().getRenderCode()));
      }
    }
  }
}