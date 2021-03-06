package model.map;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;
import model.enemy.EnemyGenerator;
import model.entity.EnemyEntity;
import model.entity.ItemEntity;
import model.item.ConsumablesGenerator;

/**
 * Class Map, berisi peta dan semua data peta.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class Map {

  //Constants
  private final int branchChance = 10;
  private final int offset = 40;
  private final int minExit = 3;
  private final int mapToEnemy = 2;
  private final int mapToItem = 1;
  private int width;
  private int height;
  private Cell[][] mapCell;
  private LinkedList<Point> mapSeed;
  private LinkedList<TransferPoint> mapExit;
  private LinkedList<EnemyEntity> enemyList;


  /**
   * Membuat map dengan width dan height terspesifikasi.
   *
   * @param width lebar map
   * @param height tinggi map
   */
  public Map(int width, int height) {
    this.width = width;
    this.height = height;

    mapCell = new Cell[height][width];

    int i;
    int j;
    //Init map
    for (i = 0; i < height; i++) {
      for (j = 0; j < width; j++) {
        mapCell[i][j] = new Cell(j, i, new Terrain(false));
      }
    }

    enemyList = new LinkedList<>();
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

    mapExit = new LinkedList<>();

    x = x1;
    y = y1;

    //Create randomizer
    Random randomGen = new Random();
    randomGen.setSeed(System.currentTimeMillis());

    //Clear starting point
    mapCell[y][x] = new Cell(x, y, new Terrain(true));

    // Add to seed
    Point branchHead = new Point(x1, y1);
    mapSeed = new LinkedList<>();
    mapSeed.addLast(branchHead);
    mapExit.add(new TransferPoint(branchHead));

    // Add to branchQueue
    LinkedList<Point> branchQueue;
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
            && !(mapCell[tempPoint.y][tempPoint.x].getTerrain().isPassable())) {
          //Check near exits
          if (isExit(tempPoint)) {
            for (j = 0; j < 4; j++) {
              tempPoint2 = nextNode(j, tempPoint);
              if (isExit(tempPoint2) && inBounds(tempPoint2)) {
                if (mapCell[tempPoint2.y][tempPoint2.x].getTerrain().isPassable()) {
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
        mapCell[y][x] = new Cell(tempPoint, new Terrain(true));
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
        } else {
          mapExit.add(new TransferPoint(tempPoint));
        }
      } else if (availMove.size() == 0) {
        //Remove the head
      } else {
        branchQueue.addLast(branchHead);
      }

      if (branchQueue.isEmpty()) {
        if (mapExit.size() > minExit) {
          finishGenerate = true;
        } else {
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
    } else {
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
    } else if (point.y >= 0 && point.y < height && point.x >= 0 && point.x < width) {
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
    } else if (movement == 1) {
      x = x - 1;
    } else if (movement == 2) {
      y = y + 1;
    } else if (movement == 3) {
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

  public void setMapCell(Cell cell, Point p) {
    mapCell[p.y][p.x] = cell;
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

  /**
   * Mengembalikan cell pada posisi tertentu.
   *
   * @param position posisi cell
   * @return cell pada posisi
   */
  public Cell getMapCell(Point position) {
    return mapCell[position.y][position.x];
  }

  /**
   * Mengembalikan transferpoint pada posisi p.
   *
   * @param p lokasi transfer point
   * @return transfer point pada lokasi
   */
  public TransferPoint getTransferPoint(Point p) {
    int i = 0;
    boolean found = false;
    while (i < mapExit.size() && !found) {
      if (mapExit.get(i).getExitPoint().equals(p)) {
        found = true;
      } else {
        i++;
      }
    }
    if (found) {
      return mapExit.get(i);
    } else {
      return null;
    }
  }

  /**
   * Mengembalikan list enemy.
   *
   * @return list enemy
   */
  public LinkedList<EnemyEntity> getEnemyList() {
    return enemyList;
  }

  /**
   * Mengembalikan nilai apakah titik ada di dalam range.
   *
   * @param p posisi
   * @return nilai apakah titik ada di dalam range
   */
  public boolean isInRange(Point p) {
    return (p.x >= 0 && p.x < width && p.y >= 0 && p.y < height);
  }

  /**
   * Mengembalikan seed map.
   *
   * @return List berisi titik kosong pada map
   */
  public LinkedList<Point> getMapSeed() {
    return mapSeed;
  }

  /**
   * Meletakkan item pada map.
   */
  public void putEnemy() {
    int i;
    int rg;
    Point randomLoc;
    EnemyGenerator enemyGen = new EnemyGenerator();
    Random randomGen = new Random(System.currentTimeMillis());
    EnemyEntity enemyEntity;

    for (i = 0; i < (mapSeed.size() * mapToEnemy) / 100; i++) {
      randomLoc = mapSeed.get(randomGen.nextInt(mapSeed.size()));
      enemyEntity = new EnemyEntity(randomLoc, enemyGen.generateEnemy());
      enemyList.addLast(enemyEntity);
      mapCell[randomLoc.y][randomLoc.x].setEntity(enemyEntity);
    }
  }

  /**
   * Meletakkan enemy pada map.
   */
  public void putItem() {
    int i;
    int rg;
    Point randomLoc;
    ConsumablesGenerator consumGen = new ConsumablesGenerator();
    Random randomGen = new Random(System.currentTimeMillis());
    ItemEntity consumables;

    for (i = 0; i < (mapSeed.size() * mapToItem) / 100; i++) {
      randomLoc = mapSeed.get(randomGen.nextInt(mapSeed.size()));
      consumables = new ItemEntity(randomLoc, consumGen.generateConsumables());
      mapCell[randomLoc.y][randomLoc.x].setEntity(consumables);
    }
  }
}
