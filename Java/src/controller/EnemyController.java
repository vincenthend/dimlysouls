package controller;

import model.entity.EnemyEntity;
import java.util.Random;

public class EnemyController extends Thread {
  private EnemyEntity enemyEntity;
  private boolean isRunning;

  public EnemyController(EnemyEntity enemyEntity) {
    this.enemyEntity = enemyEntity;
    isRunning = true;
  }

  public void run() {
    int move;
    Random rand = new Random();
    try {
      sleep(1000 / enemyEntity.getEnemy().getSpeed());
      move = -1;
      while (move == - 1){
        move = rand.nextInt(4);
        if (move == 0){
          if (){

          }
          else {
            move = -1;
          }
        }
        else if (move == 1){
          if (){

          }
          else {
            move = -1;
          }
        }
        else if (move == 2){
          if (){

          }
          else {
            move = -1;
          }
        }
        else if (move == 3){
          if (){

          }
          else {
            move = -1;
          }
        }
      }
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
    }
  }
  public void kill(){
    isRunning = false;
  }
}
