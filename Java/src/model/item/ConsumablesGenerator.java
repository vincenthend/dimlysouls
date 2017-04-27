package model.item;

import java.util.Random;

/**
 * Class EnemyGenerator generates a random enemy.
 */
public class ConsumablesGenerator {

  public static final int countItem = 2;

  /**
   * Melakukan generate pada item secara random.
   *
   * @return item hasil random
   */
  public Consumables generateConsumables() {
    Random rand = new Random(System.currentTimeMillis());
    int i;
    Consumables consumables = null;
    i = rand.nextInt(countItem);

    if (i == 0) {
      consumables = new Potion();
    } else if (i == 1) {
      consumables = new ExpBook();
    }

    return consumables;
  }
}
