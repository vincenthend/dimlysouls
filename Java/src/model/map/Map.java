package model.map;

/**
 *
 */
public class Map {


  private int width;
  private int height;
  private String mapSeed;
  private Cell[][] mapCell;

  /**
   * Default constructor
   */
  public Map() {
  }

  /**
   * Menambahkan cell pada lokasi posX dan lokasi posY
   */
  public void addCell(Cell cell, int posX, int posY) {
    // TODO implement here
  }

  /**
   * @return
   */
  public void generateMap() {
    // TODO implement here

  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Cell getMapCell(int i, int j) {
    return mapCell[i][j];
  }
}