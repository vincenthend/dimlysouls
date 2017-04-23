package model.map;

import model.entity.Entity;

/**
 *
 */
public class Cell {


  private int posX;
  private int posY;
  private Entity entity;

  /**
   * Default constructor
   */
  public Cell() {
  }

  public Entity getEntity() {
    return entity;
  }
}