package controller;

import model.entity.EnemyEntity;
import model.map.Map;

import java.util.Random;

public class EnemyController extends Thread {
  private EnemyEntity enemyEntity;
  private boolean isRunning;
  private Map map;

  public EnemyController(EnemyEntity enemyEntity, Map M) {
    this.enemyEntity = enemyEntity;
    map = M;
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
          if (map.inBounds(enemyEntity.getPosition()) && map.getMapCell()){

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
