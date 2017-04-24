package model.map;

import model.entity.Entity;

/**
 *
 */
public class Cell {

  private int posX;
  private int posY;
  private Entity entity;
  private Cell nextCell;


  public Cell(int x, int y, Entity e) {
    posX = x;
    posY = y;
    entity = e;
  }

  public Entity getEntity() {
    return entity;
  }
}