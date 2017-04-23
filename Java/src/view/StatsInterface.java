package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.player.Player;

/**
 * Created by vince on 22/04/2017.
 */
public class StatsInterface extends JPanel{

  public StatsInterface(Player P) {
    setLayout(new GridBagLayout());

    GridBagConstraints label = new GridBagConstraints();
    label.gridx = 0;
    label.gridy = 0;
    label.gridwidth = 50;

    GridBagConstraints stats = new GridBagConstraints();
    stats.gridx = 1;
    stats.gridy = 0;
    stats.gridwidth = 30;

    add(new JLabel("Name"), label);
    label.gridy++;
    add(new JLabel("ATK"), label);
    label.gridy++;
    add(new JLabel("DEF"), label);
    label.gridy++;
    add(new JLabel("Lv"), label);
    label.gridy++;
    add(new JLabel("Next"), label);
    label.gridy++;

    add(new JLabel(P.getNama()), stats);
    stats.gridy++;
    add(new JLabel(Integer.toString(P.getAttack())), stats);
    stats.gridy++;
    add(new JLabel(Integer.toString(P.getDefense())), stats);
    stats.gridy++;
    add(new JLabel(Integer.toString(P.getLevel())), stats);
    stats.gridy++;
    add(new JLabel(Integer.toString(P.getNext())), stats);
    stats.gridy++;

  }

}
