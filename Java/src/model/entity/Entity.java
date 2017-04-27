package model.entity;

import java.awt.Point;

/**
 * Kelas Abstrak Entity untuk diletakkan di cell.
 *
 * @author Vincent Hendryanto H/ 13515089
 */
public abstract class Entity {

  public static final int LEFT = 0;
  public static final int RIGHT = 1;
  public static final int UP = 2;
  public static final int DOWN = 3;
  protected Point location;
  protected String renderCode;
  protected int entityId;

  /**
   * Konstruktor kelas Entity.
   *
   * @param x absis objek entity
   * @param y absis objek entity
   */
  public Entity(int x, int y) {
    location = new Point(x, y);
  }

  /**
   * Konstruktor kelas Entity.
   *
   * @param location lokasi objek entity
   */
  public Entity(Point location) {
    this.location = new Point(location);
  }

  /**
   * Konstruktor kelas Entity.
   *
   * @param x absis objek entity
   * @param y absis objek entity
   * @param eid ID entity
   */
  public Entity(int x, int y, int eid) {
    location = new Point(x, y);
    entityId = eid;
  }

  /**
   * Konstruktor kelas Entity.
   *
   * @param location lokasi objek entity
   * @param eid ID entity
   */
  public Entity(Point location, int eid) {
    this.location = new Point(location);
    entityId = eid;
  }

  /**
   * Mengembalikan renderCode entity.
   *
   * @return renderCode entity
   */
  public String getRenderCode() {
    return renderCode;
  }

  /**
   * Mengembalikan posisi entity.
   *
   * @return posisi entity
   */
  public Point getPosition() {
    return (location);
  }


  /**
   * Mengembalikan posisi entity setelah bergerak.
   *
   * @param i arah gerak
   * @return posisi entity
   */
  public Point getPosition(int i) {
    if (i == LEFT) {
      return (new Point(location.x - 1, location.y));
    } else if (i == RIGHT) {
      return (new Point(location.x + 1, location.y));
    } else if (i == UP) {
      return (new Point(location.x, location.y - 1));
    } else if (i == DOWN) {
      return (new Point(location.x, location.y + 1));
    } else {
      return null;
    }
  }

  /**
   * Menggerakkan entity.
   *
   * @param i arah gerak
   */
  public void move(int i) {
    if (i == LEFT) {
      location.x = location.x - 1;
    } else if (i == RIGHT) {
      location.x = location.x + 1;
    } else if (i == UP) {
      location.y = location.y - 1;
    } else if (i == DOWN) {
      location.y = location.y + 1;
    }
  }

  /**
   * Mengembalikan ID entity.
   *
   * @return nilai ID Entity
   */
  public int getEntityId() {
    return entityId;
  }

  /**
   * mengatur ID Entity
   *
   * @param entityId ID Entity.
   */
  public void setEntityId(int entityId) {
    this.entityId = entityId;
  }

  /**
   * Setter posisi entity.
   *
   * @param p posisi entity
   */
  public void setPosition(Point p) {
    location.x = p.x;
    location.y = p.y;
  }
}
