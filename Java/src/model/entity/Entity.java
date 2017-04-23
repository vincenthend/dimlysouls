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
  public Entity() {
  }

  public String getRenderCode(){
    return renderCode;
  }

}