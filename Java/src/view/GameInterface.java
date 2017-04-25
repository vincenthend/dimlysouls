package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import model.map.Map;

/**
 * Kelas GameInterface mengatur isi interface.
 * @author Vincent H
 */
public class GameInterface extends JFrame {
  private ActionListener[] actionListener;
  private PlayerEntity player;
  private StatsInterface statsInterface;
  private MapInterface mapInterface;

  /**
   * Default constructor
   */
  public GameInterface() {
    super("Dimly Souls");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   * @param m1 mouseListener for newGame
   * @param m2 mouseListener for loadGame
   */
  public void switchToMainMenu(ActionListener m1) {
    removeContent();
    JPanel menuPanel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    add(menuPanel);

    //set constraints
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.ipady = 40;
    constraints.insets = new Insets(10, 0, 40, 0);

    //Add Game Title
    JLabel gameTitle = new JLabel("Dimly Souls");
    gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
    menuPanel.add(gameTitle, constraints);

    //set constraints
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.ipady = 0;
    constraints.insets = new Insets(10, 0, 10, 0);

    //Add newGame button
    JButton newGame = new JButton("New Game");
    newGame.addActionListener(m1);
    newGame.setPreferredSize(new Dimension(200, 30));
    menuPanel.add(newGame, constraints);

    //set constraints
    constraints.gridy = 2;

    //Add exitGame button
    JButton exitGame = new JButton("Exit Game");
    newGame.setPreferredSize(new Dimension(200, 30));
    menuPanel.add(exitGame, constraints);

    setSize(800, 500);

    setVisible(true);
  }

  /**
   * Switch the GUI to Map Layout.
   *
   * @param keyListener actionListener for keyboard input
   */
  public void switchToMap(KeyListener keyListener, Map map) {
    addKeyListener(keyListener);
    removeContent();
    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 1;
    mapInterface = new MapInterface(map);
    add(mapInterface, c);

    c.gridx++;
    c.gridwidth = 1;
    c.insets = new Insets(0, 20, 0, 0);
    c.anchor = GridBagConstraints.LINE_END;

    statsInterface = new StatsInterface(player);
    add(statsInterface, c);
  }

  public void updateMap(Map map) {
    removeContent();
    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 1;
    mapInterface = new MapInterface(map);
    add(mapInterface, c);

    c.gridx++;
    c.gridwidth = 1;
    c.insets = new Insets(0, 20, 0, 0);
    c.anchor = GridBagConstraints.LINE_END;

    statsInterface = new StatsInterface(player);
    add(statsInterface, c);
  }

  public void switchToBattle(ActionListener skillListener[], EnemyEntity e) {

  }

  public void removeContent() {
    getContentPane().removeAll();
  }

  /**
   * Update screen content.
   */
  public void updateInterface() {
    revalidate();
    repaint();
  }

  public void battleViewUpdate(EnemyEntity e) {

  }

  public void setPlayer(PlayerEntity player) {
    this.player = player;
  }

  public MapInterface getMapInterface() {
    return mapInterface;
  }

  public StatsInterface getStatsInterface() {

    return statsInterface;
  }
}