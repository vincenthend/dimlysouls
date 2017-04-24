package model.entity;

import java.awt.*;

/**
 *
 */
public abstract class Entity {

  protected int locX;
  protected int locY;
  protected String renderCode;
  protected int entityId;

  /**
   * Default constructor
   */
  public Entity(int x, int y) {
    locX = x;
    locY = y;
  }

  public Entity(int x, int y, int eId) {
    locX = x;
    locY = y;
    entityId = eId;
  }

  public String getRenderCode(){
    return renderCode;
  }
  public Point getPosition(){
    return (new Point(locX, locY));
  }
  public int getEntityId(){
    return entityId;
  }
  public void setEntityId(int entityId) {
    this.entityId = entityId;
  }
}