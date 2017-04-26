package model.enemy;

import java.util.Random;

/**
 * Class EnemyGenerator generates a random enemy.
 */
public class EnemyGenerator {
  public static final int countEnemy = 4;

  /**
   * Melakukan generate pada musuh secara random.
   * @return musuh hasil random
   */
  public Enemy generateEnemy(){
    Random rand = new Random(System.currentTimeMillis());
    int i;
    Enemy e = null;
    i = rand.nextInt(countEnemy);

    if(i == 0){
      e = new Slime();
    }
    else if(i == 1){
      e = new Goblin();
    }

    else if(i == 2){
      e = new Minotaur();
    }
    else if(i == 3){
      e = new Skeleton();
    }


    return e;
  }
}
