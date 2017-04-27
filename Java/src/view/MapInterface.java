package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.map.Map;

/**
 * Class MapInterface, membuat interface berisi peta.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class MapInterface extends JPanel {

  private Map map;

  /**
   * Konstruktor MapInterface.
   *
   * @param map map yang digunakan
   */
  public MapInterface(Map map) {
    JLabel tempLabel;

    this.map = map;
    setLayout(new GridBagLayout());
    setBackground(Color.lightGray);
    GridBagConstraints constraints = new GridBagConstraints();

    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.gridy = 0;
    constraints.insets = new Insets(2, 4, 2, 4);

    int i;
    int j;
    for (i = 0; i < map.getHeight(); i++) {
      constraints.gridy = i;
      for (j = 0; j < map.getWidth(); j++) {
        constraints.gridx = j;
        if (map.getMapCell(j, i).getEntity() == null) {
          tempLabel = new JLabel(map.getMapCell(j, i).getTerrain().getRenderCode());
          //add(new JLabel(map.getMapCell(j, i).getTerrain().getRenderCode()), constraints);
        } else {
          tempLabel = new JLabel(map.getMapCell(j, i).getEntity().getRenderCode());
          //add(new JLabel(map.getMapCell(j, i).getEntity().getRenderCode()), constraints);
        }
        add(tempLabel, constraints);
      }
    }
  }

  /**
   * Setter untuk map.
   *
   * @param map mengatur peta yang digunakan
   */
  public void updateMap(Map map) {
    removeAll();
    this.map = map;
    setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    constraints.gridwidth = 1;
    constraints.gridheight = 1;
    constraints.gridy = 0;
    constraints.insets = new Insets(2, 4, 2, 4);

    int i;
    int j;
    for (i = 0; i < map.getHeight(); i++) {
      constraints.gridy = i;
      for (j = 0; j < map.getWidth(); j++) {
        constraints.gridx = j;
        JLabel tempLabel;
        if (map.getMapCell(j, i).getEntity() == null) {
          tempLabel = new JLabel(map.getMapCell(j, i).getTerrain().getRenderCode());
          //add(new JLabel(map.getMapCell(j, i).getTerrain().getRenderCode()), constraints);
        } else {
          tempLabel = new JLabel(map.getMapCell(j, i).getEntity().getRenderCode());
          add(new JLabel(map.getMapCell(j, i).getEntity().getRenderCode()), constraints);
        }

        add(tempLabel, constraints);
      }
    }
  }
}