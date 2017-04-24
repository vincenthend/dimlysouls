package model.enemy;

/**
 * Class EnemyGenerator generates a random enemy
 */
public class EnemyGenerator {
  public static final int countEnemy = 1;

  public Enemy generateEnemy(int i){
    Enemy e = null;
    if(i == 1){
      e = new Slime();
    }

    return e;
  }
}
