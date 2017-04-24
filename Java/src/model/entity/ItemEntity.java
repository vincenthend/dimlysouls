package model.entity;

import java.awt.Point;
import model.item.Consumables;

/**
 *
 */
public final class ItemEntity extends Entity {

  Consumables consumables;

  /**
   * Default constructor
   */
  public ItemEntity(int x, int y, Consumables c) {
    super(x, y,2);
    consumables = c;
    renderCode = "I";
  }

  public ItemEntity(Point location, Consumables c) {
    super(location,2);
    consumables = c;
    renderCode = "I";
  }
}