package model.map;

import java.awt.Point;
import model.entity.Entity;

/**
 *
 */
public class Cell {

  private Point location;
  private Entity entity;
  private Cell nextCell;


  public Cell(int x, int y, Entity e) {
    location = new Point(x,y);
    entity = e;
  }

  public Cell(Point location, Entity e) {
    this.location = new Point(location);
    entity = e;
  }

  public Entity getEntity() {
    return entity;
  }
}