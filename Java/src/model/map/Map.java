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
  private Cell[][] mapCell;
  private LinkedList<Point> mapSeed;

  private final int branchChance = 95;
  private final int offset = 40;

  /**
   * Membuat map dengan width dan height
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

  public void generateMap(int x1, int y1){
    int x;
    int y;
    int rg;

    Point branchHead = new Point(x1,y1);
    LinkedList<Point> branchQueue;

    x = x1;
    y = y1;

    //Create randomizer
    Random randomGen = new Random();
    randomGen.setSeed(System.currentTimeMillis());

    //Clear starting point
    System.out.println("StartingPoint :" + x + " ," + y);
    mapCell[y][x] = new Cell(x, y, new TerrainEntity(x, y, true));

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

    while (!finishGenerate) {
      branchHead = branchQueue.removeFirst();
      // Generate next point
      // Check avail nodes
      availMove = new LinkedList<>();

      for (i = 0; i < 4; i++) {
        tempPoint = nextNode(i, branchHead);
        if (inBounds(tempPoint) && !(!(pathCount >= Math.max(height,width) * offset / 10) && isExit(tempPoint))
            && mapCell[tempPoint.y][tempPoint.x].getEntity().getRenderCode().equals("#")) {
          availMove.add(i);
        }
      }

      if (availMove.size() > 0) {
        //Choose a movement
        rg = randomGen.nextInt(availMove.size());
        tempPoint = nextNode(availMove.get(rg), branchHead);
        y = tempPoint.y;
        x = tempPoint.x;
        mapCell[y][x] = new Cell(x, y, new TerrainEntity(x, y, true));
        mapSeed.add(tempPoint);
        pathCount++;
        branchHead.setLocation(x, y);

        if (!isExit(tempPoint)) {
          //Decide the need to branch
          rg = Math.abs(randomGen.nextInt(101));
          if (rg >= branchChance) {
            branchQueue.addLast(new Point(branchHead.x, branchHead.y));
          }
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
    System.out.println("Number of Path : "+pathCount);
    System.out.println("Map Seed : ");
    System.out.println(mapSeed.toString());
  }

  /**
   *
   */
  public void generateMap() {
    int rg;
    int x;
    int y;

    //Create randomizer
    Random randomGen = new Random();
    randomGen.setSeed(System.currentTimeMillis());

    // Choose the starting point
    rg = randomGen.nextInt(2);
    if (rg == 1) {
      x = Math.abs((randomGen.nextInt() % (width - 1)) + 1);
      y = (randomGen.nextInt() % 2 == 0) ? 0 : (height - 1);
    }
    else {
      x = (randomGen.nextInt() % 2 == 0) ? 0 : (width - 1);
      y = Math.abs((randomGen.nextInt() % (height - 1)) + 1);
    }

    generateMap(x,y);
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