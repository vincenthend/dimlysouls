package model.map;

/**
 * Kelas Terrain mengatur apakah jalan dapat dilewati.
 */
public class Terrain {

  private boolean passable;
  private String renderCode;

  /**
   * Konstruktor kelas terrain.
   *
   * @param passable nilai passable
   */
  public Terrain(boolean passable) {
    this.passable = passable;
    if (passable) {
      renderCode = " ";
    } else {
      renderCode = "#";
    }
  }

  /**
   * Mengembalikan nilai passable (jalan dapat dilalui).
   *
   * @return nilai passable
   */
  public boolean isPassable() {
    return passable;
  }

  /**
   * Mengembalikan renderCode terrain.
   *
   * @return renderCode terrain
   */
  public String getRenderCode() {
    return renderCode;
  }
}