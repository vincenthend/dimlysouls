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
  public Map(int width, int height) {
    this.width = width;
    this.height = height;

    mapCell = new Cell[height][width];
  }

  /**
   *
   */
  public void generateMap() {
    //Choose the starting point

  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  /**
   * Menambahkan cell pada lokasi posX dan lokasi posY
   */
  public void setMapCell(Cell cell, int posX, int posY) {
    mapCell[posY][posX] = cell;
  }

  public Cell getMapCell(int i, int j) {
    return mapCell[i][j];
  }
}