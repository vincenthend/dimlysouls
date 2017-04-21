package controller;

import model.entity.EnemyEntity;
import model.entity.PlayerEntity;

/**
 *
 */
public class EnemyBattleController extends Thread{
  private PlayerEntity P;
  private EnemyEntity E;

  /**
   * Membuat EnemyBattleController dengan Player terlibat P
   * @param P
   */
  public EnemyBattleController(PlayerEntity P){

  }


  /**
   * Menyerang thread jika HP > 0 tiap (600/speed) detik
   */
  public void run(){

  }


}
