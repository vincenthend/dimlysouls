package model.map;

import model.entity.TerrainEntity;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 */
public class Map {
  private int width;
  private int height;
  private Cell[][] mapCell;
  private LinkedList<Point> mapSeed;
  private LinkedList<TransferPoint> mapExit;
  //Constants
  private final int branchChance = 10;
  private final int offset = 40;
  private final int minExit = 3;

  /**
   * Membuat map dengan width dan height terspesifikasi.
   *
   * @param width lebar map
   * @param height tinggi map
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
   * Membuat map dengan titik awal x1 dan y1.
   *
   * @param x1 absis awal pembuatan map
   * @param y1 ordinat awal pembuatan map
   */
  public void generateMap(int x1, int y1) {
    int x;
    int y;
    int rg;

    Point branchHead = new Point(x1, y1);
    LinkedList<Point> branchQueue;
    mapExit = new LinkedList<>();

    x = x1;
    y = y1;

    //Create randomizer
    Random randomGen = new Random();
    randomGen.setSeed(System.currentTimeMillis());

    //Clear starting point
    mapCell[y][x] = new Cell(x, y, new TerrainEntity(branchHead, true));

    // Add to seed
    mapSeed = new LinkedList<>();
    mapSeed.addLast(branchHead);
    mapExit.add(new TransferPoint(branchHead));

    // Add to branchQueue
    branchQueue = new LinkedList<>();
    branchQueue.addLast(new Point(x, y));

    // Generate other point
    boolean finishGenerate = false;
    boolean exitsafe;
    int pathCount = 1;
    int i;
    int j;
    Point tempPoint;
    Point tempPoint2;
    LinkedList<Integer> availMove;

    while (!finishGenerate) {
      branchHead = branchQueue.removeFirst();
      // Check avail nodes
      availMove = new LinkedList<>();
      exitsafe = true;
      for (i = 0; i < 4; i++) {
        tempPoint = nextNode(i, branchHead);
        if (inBounds(tempPoint) && !(!(pathCount >= height * width * offset / 100)
            && isExit(tempPoint))
            && mapCell[tempPoint.y][tempPoint.x].getEntity().getRenderCode().equals("#")) {
          //Check near exits
          if (isExit(tempPoint)) {
            for (j = 0; j < 4; j++) {
              tempPoint2 = nextNode(j, tempPoint);
              if (isExit(tempPoint2) && inBounds(tempPoint2)) {
                if (mapCell[tempPoint2.y][tempPoint2.x].getEntity().getRenderCode().equals(" ")) {
                  exitsafe = false;
                }
              }
            }
          }

          if (exitsafe) {
            availMove.add(i);
          }
        }
      }

      if (availMove.size() > 0) {
        //Choose a movement
        rg = randomGen.nextInt(availMove.size());
        tempPoint = nextNode(availMove.get(rg), branchHead);
        y = tempPoint.y;
        x = tempPoint.x;
        mapCell[y][x] = new Cell(tempPoint, new TerrainEntity(tempPoint, true));
        mapSeed.add(tempPoint);
        pathCount++;
        branchHead.setLocation(x, y);

        if (!isExit(tempPoint)) {
          //Decide the need to branch
          rg = Math.abs(randomGen.nextInt(101));
          if (rg >= 100 - branchChance) {
            branchQueue.addLast(new Point(branchHead.x, branchHead.y));
          }
          branchQueue.addLast(branchHead);
        }
        else {
          mapExit.add(new TransferPoint(tempPoint));
        }
      }
      else if (availMove.size() == 0) {
        //Remove the head
      }
      else {
        branchQueue.addLast(branchHead);
      }

      if (branchQueue.isEmpty()) {
        if (mapExit.size() > minExit) {
          finishGenerate = true;
        }
        else {
          do {
            rg = randomGen.nextInt(mapSeed.size());
            branchQueue.addLast(mapSeed.get(rg));
          } while (isExit(branchQueue.getLast()));
        }
      }
    }
  }

  /**
   * Membuat map dengan nilai titik awal tidak diketahui.
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

    generateMap(x, y);
  }

  /**
   * Membuat map dengan nilai titik awal berupa Point.
   *
   * @param point titik awal pembuatan map
   */
  public void generateMap(Point point) {
    generateMap(point.x, point.y);
  }

  /**
   * Menguji apakah titik yang dimasukkan ada di dalam map.
   *
   * @param point titik yang diuji
   * @return nilai boolean apakah titik ada di dalam map
   */
  public boolean inBounds(Point point) {
    boolean avail = false;
    if ((point.x == 0 || point.x == width) && (point.y == 0 || point.y == height - 1)) {
      avail = false;
    }
    else if (point.y >= 0 && point.y < height && point.x >= 0 && point.x < width) {
      avail = true;
    }
    return avail;
  }

  /**
   * Menguji apakah titik yang dimasukkan berada di ujung map.
   *
   * @param point titik yang diuji
   * @return nilai boolean apakah titik ada di ujung map
   */
  private boolean isExit(Point point) {
    return (point.x == 0 || point.x == width - 1 || point.y == 0 || point.y == height - 1);
  }

  /**
   * Menghasilkan nilai point selanjutnya sesuai kode movement.
   *
   * @param movement kode pergerakan, 0 atas, 1 kiri, 2 bawah, 3 kanan
   * @param point point lokasi sekarang
   * @return nilai point selanjutnya
   */
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

  /**
   * Mengembalikan lebar map.
   *
   * @return lebar map
   */
  public int getWidth() {
    return width;
  }

  /**
   * Mengembalikan tinggi map.
   *
   * @return tinggi map
   */
  public int getHeight() {
    return height;
  }

  /**
   * Menambahkan cell pada lokasi posX dan lokasi posY.
   *
   * @param cell cell yang dimasukkan
   * @param posX nilai absis cell
   * @param posY nilai ordinat cell
   */
  public void setMapCell(Cell cell, int posX, int posY) {
    mapCell[posY][posX] = cell;
  }

  /**
   * Mengembalikan cell pada lokasi x dan y.
   *
   * @param x absis cell
   * @param y ordinat cell
   * @return cell pada (x,y)
   */
  public Cell getMapCell(int x, int y) {
    return mapCell[y][x];
  }

  public Cell getMapCell(Point position) {
    return mapCell[position.y][position.x];
  }
}