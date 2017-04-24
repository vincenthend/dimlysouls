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
    this.width = width;
    this.height = height;

    mapCell = new Cell[height][width];
  }
  /**
   *
   */
  public void generateMap() {
    int rg;
    int i;
    int j;
    int x;
    int y;
    LinkedList<Integer> mapSeed;

    Random randomgen = new Random();
    randomgen.setSeed(System.currentTimeMillis());

    //Init map
    for(i = 0; i<height; i++){
      for(j = 0; j<width; j++){
        mapCell[i][j] = new Cell(j,i,new TerrainEntity(j,i,true));
      }
    }

    //Choose the starting point
    rg = randomgen.nextInt() % 2;
    if (rg == 1) {
      x = Math.abs((randomgen.nextInt() % (width - 1)) + 1);
      y = (randomgen.nextInt() % 2 == 0) ? 1 : (height - 2);
    } else {
      x = (randomgen.nextInt() % 2 == 0) ? 1 : (width - 2);
      y = Math.abs((randomgen.nextInt() % (height - 1)) + 1);
    }



    mapSeed = new LinkedList<Integer>();
    mapSeed.addLast(x);
    mapSeed.addLast(y);

    System.out.println("StartingPoint :"+x+" ,"+y);

    rg = Math.abs(randomgen.nextInt(4));




  }

  // 0 : up
  // 1 : left
  // 2 : down
  // 3 : right
  private boolean inBounds(int movement, int x, int y){
    boolean avail = false;
    if(movement == 0 && y-1 >= 0){
      avail = true;
    }
    else if(movement == 1 && x-1 >= 0){
      avail = true;
    }
    else if(movement == 2 && y+1 < height){
      avail = true;
    }
    else if(movement == 3 && y-1 < width){
      avail = true;
    }

    return avail;
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