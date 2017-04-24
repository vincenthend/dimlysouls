package controller;

import model.entity.EnemyEntity;

import java.util.Random;

public class EnemyController extends Thread {
  EnemyEntity enemyEntity;
  boolean isRunning;

  public EnemyController(EnemyEntity enemyEntity) {
    this.enemyEntity = enemyEntity;
    isRunning = true;
  }

  public void run() {
    int move;
    Random rand = new Random();
    try {
      sleep(1000 / enemyEntity.getEnemy().getSpeed());
      move = rand.nextInt(4);
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
  }
  public void kill(){
    isRunning = false;
  }
}
