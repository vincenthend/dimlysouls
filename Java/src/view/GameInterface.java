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
import view.Battle.BattleInterface;

/**
 * Kelas GameInterface mengatur isi interface.
 *
 * @author Vincent H
 */
public class GameInterface extends JFrame {
  private ActionListener actionListener;
  private StatsInterface statsInterface;
  private BattleInterface battleInterface;
  private MapInterface mapInterface;
  private PlayerEntity player;
  private EnemyEntity enemy;
  private int status;
  public static final int MAIN_MENU = 0;
  public static final int MAP = 1;
  public static final int BATTLE = 2;

  /**
   * Default constructor
   */
  public GameInterface() {
    super("Dimly Souls");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    status = MAIN_MENU;
  }

  /**
   * @param m1 mouseListener for newGame
   */
  public void switchToMainMenu(ActionListener m1) {
    status = MAIN_MENU;
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
    status = MAP;
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

  /**
   * Berpindah ke BattleInterface
   *
   * @param a actionListener untuk menampung input serangan
   * @param e musuh yang terlibat
   */
  public void switchToBattle(ActionListener a, EnemyEntity e) {
    status = BATTLE;
    actionListener = a;
    enemy = e;
    removeContent();
    battleInterface = new BattleInterface(player, enemy, actionListener);
    add(battleInterface);
  }

  /**
   * Update screen content.
   */
  public void updateInterface() {
    revalidate();
    repaint();
  }

  /**
   * Melakukan update pada interface battle
   */
  public void updateBattle() {
    removeContent();
    battleInterface = new BattleInterface(player, enemy, actionListener);
    add(battleInterface);
  }

  // Misc Method

  /**
   * Menghapus semua content di dalam JFrame.
   */
  public void removeContent() {
    getContentPane().removeAll();
  }

  // Setter and Getter

  public void setPlayer(PlayerEntity player) {
    this.player = player;
  }

  public MapInterface getMapInterface() {
    return mapInterface;
  }

  public StatsInterface getStatsInterface() {

    return statsInterface;
  }

  public int getStatus() {
    return status;
  }

  public BattleInterface getBattleInterface() {
    return battleInterface;
  }
}