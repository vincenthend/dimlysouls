package model.map;

import java.awt.Point;
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
    final int branchChance = 90;
    final int offset = 20;
    Point branchHead;
    LinkedList<Point> branchQueue;
    LinkedList<Point> mapSeed;

    //Create randomizer
    Random randomGen = new Random();
    randomGen.setSeed(System.currentTimeMillis());

    // Choose the starting point
    rg = randomGen.nextInt(2);
    branchHead = new Point();
    if (rg == 1) {
      branchHead.x = Math.abs((randomGen.nextInt() % (width - 1)) + 1);
      branchHead.y = (randomGen.nextInt() % 2 == 0) ? 0 : (height - 1);
    }
    else {
      branchHead.x = (randomGen.nextInt() % 2 == 0) ? 0 : (width - 1);
      branchHead.y = Math.abs((randomGen.nextInt() % (height - 1)) + 1);
    }

    //Clear starting point
    x = branchHead.x;
    y = branchHead.y;
    System.out.println("StartingPoint :" + x + " ," + y);
    mapCell[y][x] = new Cell(y, x, new TerrainEntity(y, x, true));

    // Add to seed
    mapSeed = new LinkedList<>();
    mapSeed.addLast(branchHead);

    // Add to branchQueue
    branchQueue = new LinkedList<>();
    branchQueue.addLast(new Point(x, y));

    // Generate other point
    boolean finishGenerate = false;
    int pathCount = 1;
    int i;
    Point tempPoint;
    LinkedList<Integer> availMove;
    int branchCount = 0;

    while (!finishGenerate) {
      branchHead = branchQueue.removeFirst();
      // Generate next point
      // Check avail nodes
      availMove = new LinkedList<>();

      for (i = 0; i < 4; i++) {
        tempPoint = nextNode(i, branchHead);
        if (inBounds(tempPoint) && !(!(pathCount >= height * offset / 10) && isExit(tempPoint))
            && mapCell[tempPoint.y][tempPoint.x].getEntity().getRenderCode() == "#") {
          availMove.add(i);
        }
      }

      if (availMove.size() > 0) {
        //Choose a movement
        rg = randomGen.nextInt(availMove.size());
        tempPoint = nextNode(availMove.get(rg), branchHead);
        y = tempPoint.y;
        x = tempPoint.x;
        mapCell[y][x] = new Cell(y, x, new TerrainEntity(y, x, true));
        pathCount++;
        branchHead.setLocation(x, y);

        if (!isExit(tempPoint)) {
          //Decide the need to branch
          /*rg = Math.abs(randomGen.nextInt(101));
          if (rg >= branchChance && branchCount < 4) {
            branchCount++;
            branchQueue.addLast(new Point(branchHead.x, branchHead.y));
            System.out.println("Branch at :" + branchHead.x + " ," + branchHead.y);
          }*/
          branchQueue.addLast(branchHead);
        }
      }
      else if (availMove.size() == 0) {
        //Remove the head
      }
      else {
        branchQueue.addLast(branchHead);
      }

      if (branchQueue.isEmpty()) {
        finishGenerate = true;
      }
    }
  }

  // 0 : up
  // 1 : left
  // 2 : down
  // 3 : right
  private boolean inBounds(Point point) {
    boolean avail = false;
    if ((point.x == 0 || point.x == width) && (point.y == 0 || point.y == height - 1)) {
      avail = false;
    }
    else if (point.y >= 0 && point.y < height && point.x >= 0 && point.x < width) {
      avail = true;
    }
    return avail;
  }

  private boolean isExit(Point point) {
    return (point.x == 0 || point.x == width - 1 || point.y == 0 || point.y == height - 1);
  }

  private Point nextNode(int movement, Point point) {
    int x = point.x;
    int y = point.y;
    Point retPoint = new Point();

    if (movement == 0) {
      y = y - 1;
    }
    else if (movement == 1) {
      x = x - 1;
    }
    else if (movement == 2) {
      y = y + 1;
    }
    else if (movement == 3) {
      x = x + 1;
    }
    retPoint.setLocation(x, y);

    return retPoint;
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