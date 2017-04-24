package model.entity;

import java.awt.Point;

/**
 *
 */
public abstract class Entity {
  protected Point location;
  protected String renderCode;
  protected int entityId;

  /**
   * Konstruktor kelas Entity.
   * @param x absis objek entity
   * @param y absis objek entity
   */
  public Entity(int x, int y) {
    location = new Point(x, y);
  }

  /**
   * Konstruktor kelas Entity.
   * @param location lokasi objek entity
   */
  public Entity(Point location) {
    this.location = new Point(location);
  }

  /**
   * Konstruktor kelas Entity.
   * @param x absis objek entity
   * @param y absis objek entity
   * @param eId ID entity
   */
  public Entity(int x, int y, int eId) {
    location = new Point(x, y);
    entityId = eId;
  }

  /**
   * Konstruktor kelas Entity.
   * @param location lokasi objek entity
   * @param eId ID entity
   */
  public Entity(Point location, int eId) {
    this.location = new Point(location);
    entityId = eId;
  }

  /**
   * Mengembalikan renderCode entity.
   * @return renderCode entity
   */
  public String getRenderCode() {
    return renderCode;
  }

  /**
   * Mengembalikan posisi entity.
   * @return posisi entity
   */
  public Point getPosition() {
    return (new Point(location));
  }

  /**
   * Mengembalikan ID entity.
   * @return
   */
  public int getEntityId() {
    return entityId;
  }

  /**
   * mengatur ID Entity
   * @param entityId ID Entity.
   */
  public void setEntityId(int entityId) {
    this.entityId = entityId;
  }
}