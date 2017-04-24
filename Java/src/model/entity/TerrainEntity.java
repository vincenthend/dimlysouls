package model.entity;

import java.awt.Point;

/**
 *
 */
public class TerrainEntity extends Entity {

  private boolean isPassable;

  /**
   * Default constructor
   */
  public TerrainEntity(int x, int y, boolean isPassable) {
    super(x, y);
    this.isPassable = isPassable;
    if (isPassable) {
      renderCode = " ";
      setEntityId(30);
    } else {
      renderCode = "#";
      setEntityId(31);
    }
  }

  public TerrainEntity(Point location, boolean isPassable) {
    super(location);
    this.isPassable = isPassable;
    if (isPassable) {
      renderCode = " ";
      setEntityId(30);
    } else {
      renderCode = "#";
      setEntityId(31);
    }
  }

}