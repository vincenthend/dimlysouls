package view;

import model.entity.EnemyEntity;
import model.entity.PlayerEntity;
import model.map.Map;
import model.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 *
 */
public class GameInterface extends JFrame {

  private ActionListener[] actionListener;
  private Player player;

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
  public void switchToMainMenu(ActionListener m1, ActionListener m2) {
    getContentPane().removeAll();
    JPanel menuPanel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    add(menuPanel);

    //set constraints
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.ipady = 40;
    constraints.insets = new Insets(10,0,40,0);

    //Add Game Title
    JLabel gameTitle = new JLabel("Dimly Souls");
    gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
    menuPanel.add(gameTitle,constraints);

    //set constraints
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.ipady = 0;
    constraints.insets = new Insets(10,0,10,0);

    //Add newGame button
    JButton newGame = new JButton("New Game");
    newGame.addActionListener(m1);
    newGame.setPreferredSize(new Dimension(200,30));
    menuPanel.add(newGame,constraints);

    //set constraints
    constraints.gridy = 2;

    //Add loadGame button
    JButton loadGame = new JButton("Load Game");
    loadGame.addActionListener(m2);
    newGame.setPreferredSize(new Dimension(200,30));
    menuPanel.add(loadGame,constraints);

    //set constraints
    constraints.gridy = 3;

    //Add exitGame button
    JButton exitGame = new JButton("Exit Game");
    newGame.setPreferredSize(new Dimension(200,30));
    menuPanel.add(exitGame,constraints);

    setSize(500, 500);

    setVisible(true);
  }

  /**
   * Switch the GUI to Map Layout.
   *
   * @param keyListener actionListener for keyboard input
   */
  public void switchToMap(KeyListener keyListener, Map map) {

  }

  public void switchToBattle(MouseListener mouseListener) {

  }

  public void removeContent(){
    getContentPane().removeAll();
  }

  /**
   * Update screen content.
   */
  public void updateInterface() {
    revalidate();
    repaint();
  }
  public void createBattleInterface(PlayerEntity p, EnemyEntity e) {

  }

  public void setPlayer(Player player) {
    this.player = player;
  }
}