package model.entity;

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

  public int getEntityId(){
    return entityId;
  }
  public void setEntityId(int entityId) {
    this.entityId = entityId;
  }
}