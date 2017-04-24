package controller;

import model.entity.EnemyEntity;
import model.entity.PlayerEntity;

public class PlayerBattleController extends Thread {
  private PlayerEntity playerEntity;
  private EnemyEntity enemyEntity;
  private boolean isRunning;

  public PlayerBattleController(PlayerEntity p, EnemyEntity e) {
  }

  public void run() {
  }

  public void calculateDamage() {
  }

  public void kill() {
    isRunning = false;
  }
}