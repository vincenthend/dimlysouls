package model.entity;

import model.item.Consumables;

import java.awt.*;

/**
 * ItemEntity, berisi item.
 *
 * @author Vincent Hendryanto H/ 13515089
 */
public final class ItemEntity extends Entity {

  Consumables consumables;

  /**
   * Default constructor.
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

  /**
   * Getter player terkait.
   *
   * @return player terkait
   */
  public Consumables getConsumables() {
    return consumables;
  }
}