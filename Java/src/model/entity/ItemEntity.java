package model.entity;

import java.awt.Point;
import model.item.Consumables;

/**
 * ItemEntity, berisi item.
 *
 * @author Vincent Hendryanto H/ 13515089
 */
public final class ItemEntity extends Entity {

  Consumables consumables;

  /**
   * Default constructor.
   * @param x absis lokasi objek
   * @param y ordinat lokasi objek
   * @param c objek consumables
   */
  public ItemEntity(int x, int y, Consumables c) {
    super(x, y, 2);
    consumables = c;
    renderCode = "I";
  }

  /**
   * Konstruktor item entity.
   *
   * @param location lokasi item
   * @param c item
   */
  public ItemEntity(Point location, Consumables c) {
    super(location, 2);
    consumables = c;
    renderCode = "I";
  }
}