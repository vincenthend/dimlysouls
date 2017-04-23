package model.entity;

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
    super(x, y);
    consumables = c;
    renderCode = "I";
  }
}