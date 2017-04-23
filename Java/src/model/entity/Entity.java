package model.entity;

/**
 *
 */
public abstract class Entity {

  protected int locX;
  protected int locY;
  protected String renderCode;

  /**
   * Default constructor
   */
  public Entity(int x, int y) {
    locX = x;
    locY = y;
  }

  public String getRenderCode(){
    return renderCode;
  }

}