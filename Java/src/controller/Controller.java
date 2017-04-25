package controller;

import model.entity.PlayerEntity;
import model.player.Berserker;
import model.player.Ninja;
import model.player.Paladin;
import model.player.Warrior;
import view.GameInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private static int defaultGameSpeed = 15000;
    public static int undef = -999;
    public static int RUNNING = 0;
    public static int SWITCH_TO_MAP = 1;
    public static int SWITCH_TO_BATTLE = 2;
    public static int SWITCH_TO_MENU = 3;
    public static int gameSpeed = defaultGameSpeed;
    private MapController mapController;
    private BattleController battleController;
    private GameInterface gameInterface;
    private PlayerEntity playerEntity;
    public Controller(){
        ActionListener newGame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int playerClass;
                System.out.println("New Game Invoked");
                String name = JOptionPane.showInputDialog(null, "What's your name?");
                String[] options = new String[] {"Warrior", "Paladin", "Berserker", "Ninja"};
                playerClass = JOptionPane.showOptionDialog(null, "Choose your class", "Class Selection",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (playerClass == 0) {
                    playerEntity = new PlayerEntity(undef, undef, new Warrior(name));
                }
                else if (playerClass == 1) {
                    playerEntity = new PlayerEntity(undef, undef, new Paladin(name));
                }
                else if (playerClass == 2) {
                    playerEntity = new PlayerEntity(undef, undef, new Berserker(name));
                }
                else if (playerClass == 3) {
                    playerEntity = new PlayerEntity(undef, undef, new Ninja(name));
                }
                mapController = new MapController(playerEntity, gameInterface);
            }
        };
        ActionListener loadGame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Load Game Invoked");
            }
        };
        ActionListener exitGame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Exit Game Invoked");
            }
        };
        gameInterface.switchToMainMenu(newGame, loadGame, exitGame);
        gameInterface.updateInterface();
    }
}
