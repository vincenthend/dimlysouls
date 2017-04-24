package model.entity;

import java.awt.*;

/**
 *
 */
public abstract class Entity {

  protected Point location;
  protected String renderCode;
  protected int entityId;

  /**
   * Default constructor
   */
  public Entity(int x, int y) {
    location = new Point(x,y);
  }
  public Entity(Point location) {
    this.location = new Point(location);
  }

  public Entity(int x, int y, int eId) {
    location = new Point(x,y);
    entityId = eId;
  }

  public Entity(Point location, int eId) {
    this.location = new Point(location);
    entityId = eId;
  }

  public String getRenderCode(){
    return renderCode;
  }
  public Point getPosition(){
    return (new Point(location));
  }
  public int getEntityId(){
    return entityId;
  }
  public void setEntityId(int entityId) {
    this.entityId = entityId;
  }
}