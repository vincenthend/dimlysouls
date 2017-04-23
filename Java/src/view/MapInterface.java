package view;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.map.Map;

public class MapInterface extends JPanel {

  private Map map;

  public MapInterface(Map map) {
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