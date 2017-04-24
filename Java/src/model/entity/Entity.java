package model.entity;

import java.awt.*;

/**
 *
 */
public abstract class Entity {

  protected Point location;
  protected String renderCode;
  protected int entityId;
  public static final int LEFT = 0;
  public static final int RIGHT = 1;
  public static final int UP = 2;
  public static final int DOWN = 3;

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
    return (location);
  }
  public Point getPosition(int i){
    if (i == LEFT){
      return (new Point(location.x, location.y - 1));
    }
    else if (i == RIGHT){
      return (new Point(location.x, location.y + 1));
    }
    else if (i == UP){
      return (new Point(location.x - 1, location.y));
    }
    else if (i == DOWN){
      return (new Point(location.x + 1, location.y));
    }
    else {
      return null;
    }
  }
  public void move(int i){
    if (i == LEFT){
      location.x = location.x - 1;
    }
    else if (i == RIGHT){
      location.x = location.x + 1;
    }
    else if (i == UP){
      location.x = location.y - 1;
    }
    else if (i == DOWN){
      location.x = location.y + 1;
    }
  }
  public int getEntityId(){
    return entityId;
  }
  public void setEntityId(int entityId) {
    this.entityId = entityId;
  }
}