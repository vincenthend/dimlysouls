package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.entity.PlayerEntity;
import model.player.Player;

/**
 * Class StatsInterface menampilkan stats player
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class StatsInterface extends JPanel {
  private PlayerEntity playerEntity;

  /**
   * Konstruktor kelas StatsInterface
   *
   * @param P Player yang statsnya ditampilkan
   */
  public StatsInterface(PlayerEntity P) {
    playerEntity = P;

    setLayout(new GridBagLayout());
    updateStats();
  }

  /**
   * Mengupdate isi stats
   */
  public void updateStats() {
    removeAll();
    Player player = playerEntity.getPlayer();

    GridBagConstraints label = new GridBagConstraints();
    label.gridx = 0;
    label.gridy = 0;
    label.gridwidth = 2;
    label.weightx = 1;
    label.fill = GridBagConstraints.HORIZONTAL;

    GridBagConstraints stats = new GridBagConstraints();
    stats.gridx = 3;
    stats.gridy = 0;
    stats.gridwidth = 1;
    stats.weightx = 0.5;
    stats.fill = GridBagConstraints.HORIZONTAL;

    add(new JLabel("Name"), label);
    label.gridy++;
    add(new JLabel("HP"), label);
    label.gridy++;
    add(new JLabel("ATK"), label);
    label.gridy++;
    add(new JLabel("DEF"), label);
    label.gridy++;
    add(new JLabel("Lv"), label);
    label.gridy++;
    add(new JLabel("Next"), label);
    label.gridy++;

    add(new JLabel(player.getNama()), stats);
    stats.gridy++;
    add(new JLabel(
            Integer.toString(playerEntity.getCurrentHealth()) + "/" + Integer
                .toString(player.getHealth())),
        stats);
    stats.gridy++;
    add(new JLabel(Integer.toString(player.getAttack())), stats);
    stats.gridy++;
    add(new JLabel(Integer.toString(player.getDefense())), stats);
    stats.gridy++;
    add(new JLabel(Integer.toString(player.getLevel())), stats);
    stats.gridy++;
    add(new JLabel(Integer.toString(player.getNext())), stats);
    stats.gridy++;
  }
}
