package model.map;

import java.awt.Point;
import model.entity.Entity;

/**
 * Kelas cell berisi entity yang ada di map
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class Cell {
  private Point location;
  private Entity entity;
  private Terrain terrain;

  /**
   * Konstruktor kelas cell
   *
   * @param location lokasi objek cell
   * @param terrain terrain di cell
   */
  public Cell(Point location, Terrain terrain) {
    this.location = new Point(location);
    this.terrain = terrain;
  }

  /**
   * Konstruktor kelas cell
   *
   * @param x absis objek cell
   * @param y ordinat objek cell
   * @param terrain terrain di cell
   */
  public Cell(int x, int y, Terrain terrain) {
    this.location = new Point(x,y);
    this.terrain = terrain;
  }


  /**
   * Konstruktor kelas cell
   *
   * @param location lokasi objek cell
   * @param terrain terrain di cell
   * @param entity entity di dalam cell
   */
  public Cell(Point location, Terrain terrain, Entity entity) {
    this.location = new Point(location);
    this.terrain = terrain;
    this.entity = entity;
  }

  /**
   * Konstruktor kelas cell
   *
   * @param x absis objek cell
   * @param y ordinat objek cell
   * @param terrain terrain di cell
   * @param entity entity di dalam cell
   */
  public Cell(int x, int y, Terrain terrain, Entity entity) {
    this.location = new Point(x,y);
    this.terrain = terrain;
    this.entity = entity;
  }

  /**
   * Mengembalikan entitas di dalam cell
   *
   * @return entitas di dalam cell
   */
  public Entity getEntity() {
    return entity;
  }

  /**
   * Mengatur entity di dalam cell
   * @param entity
   */
  public void setEntity(Entity entity) {
    this.entity = entity;
  }

  /**
   * Mengembalikan nilai terrain di dalam cell
   * @return terrain di dalam cell
   */
  public Terrain getTerrain() {
    return terrain;
  }

  /**
   * Mengaturn nilai terrain di dalam cell
   * @param terrain
   */
  public void setTerrain(Terrain terrain) {
    this.terrain = terrain;
  }
}