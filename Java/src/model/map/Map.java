package model.map;

import java.util.LinkedList;
import java.util.Random;
import model.entity.TerrainEntity;

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
    int i;
    int j;

    this.width = width;
    this.height = height;

    mapCell = new Cell[height][width];

    //Init map
    for (i = 0; i < height; i++) {
      for (j = 0; j < width; j++) {
        mapCell[i][j] = new Cell(j, i, new TerrainEntity(j, i, false));
      }
    }
  }
  /**
   *
   */
  public void generateMap() {
    int rg;
    int x;
    int y;
    LinkedList<Integer> mapSeed;

    Random randomgen = new Random();
    randomgen.setSeed(System.currentTimeMillis());

    //Choose the starting point
    rg = randomgen.nextInt() % 2;
    if (rg == 1) {
      x = Math.abs((randomgen.nextInt() % (width - 1)) + 1);
      y = (randomgen.nextInt() % 2 == 0) ? 0 : (height - 1);
    }
    else {
      x = (randomgen.nextInt() % 2 == 0) ? 0 : (width - 1);
      y = Math.abs((randomgen.nextInt() % (height - 1)) + 1);
    }

    //Clear the starting point
    mapSeed = new LinkedList<Integer>();
    mapSeed.addLast(x);
    mapSeed.addLast(y);

    System.out.println("StartingPoint :" + x + " ," + y);

    mapCell[y][x] = new Cell(y, x, new TerrainEntity(y, x, true));

    boolean finishGenerate = false;
    int pathCount = 0;
    while (!finishGenerate) {
      rg = Math.abs(randomgen.nextInt(4));
      // if next tiles is in Bounds & unpassable
      if (inBounds(rg, x, y) && mapCell[y][x].getEntity().getRenderCode() == "#") {
        // check no of tiles generated
        if (pathCount >= height / 2 || !isExit(x, y)) {

        }
      }
    }
  }
  // 0 : up
  // 1 : left
  // 2 : down
  // 3 : right
  private boolean inBounds(int movement, int x, int y) {
    boolean avail = false;
    if ((x == 0 || x == width) && (y == 0 || y == height - 1)) {
      avail = false;
    }
    else if (movement == 0 && y - 1 >= 0) {
      avail = true;
    }
    else if (movement == 1 && x - 1 >= 0) {
      avail = true;
    }
    else if (movement == 2 && y + 1 < height) {
      avail = true;
    }
    else if (movement == 3 && y - 1 < width) {
      avail = true;
    }

    return avail;
  }
  private boolean isExit(int x, int y) {
    return (x == 0 || x == width - 1 || y == 0 || y == height - 1);
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
  public Cell getMapCell(int x, int y) {
    return mapCell[y][x];
  }
}