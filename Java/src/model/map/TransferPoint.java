package model.map;

import java.awt.Point;

/**
 * TransferPoint digunakan untuk menghubungkan map melalui cell tertentu.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public class TransferPoint {

  private Point exitPoint;
  private Map nextMap;
  private Point entrancePoint;

  /**
   * Membuat transfer point dengan titik keluar map.
   *
   * @param exitPoint titik keluar pada map menuju entrance point
   */
  public TransferPoint(Point exitPoint) {
    this.exitPoint = exitPoint;
    this.entrancePoint = null;
    nextMap = null;
  }

  /**
   * Membuat transfer point dengan titik keluar map dan titik masuk map.
   *
   * @param exitPoint titik keluar pada map menuju entrance point
   * @param entrancePoint titik masuk pada map selanjutnya
   */
  public TransferPoint(Point exitPoint, Point entrancePoint) {
    this.exitPoint = exitPoint;
    this.entrancePoint = entrancePoint;
    nextMap = null;
  }

  /**
   * Mengembalikan point tempat keluar dari map sekarang.
   *
   * @return Point berisi cell tempat keluar
   */
  public Point getExitPoint() {
    return exitPoint;
  }

  /**
   * Mengembalikan nilai map selanjutnya.
   *
   * @return Map selanjutnya
   */
  public Map getNextMap() {
    return nextMap;
  }

  /**
   * Memasang nilai nextMap.
   *
   * @param nextMap alamat map selanjutnya
   */
  public void setNextMap(Map nextMap) {
    this.nextMap = nextMap;
  }

  /**
   * Mengembalikan titik masuk pada map selanjutnya.
   *
   * @return titik masuk pada map selanjutnya
   */
  public Point getEntrancePoint() {
    return entrancePoint;
  }

  /*
   * Memasang nilai entrancePoint pada nextmap.
   * @param entrancePoint point pertama masuk pada nextmap
   */
  public void setEntrancePoint(Point entrancePoint) {
    this.entrancePoint = entrancePoint;
  }

  /**
   * Mengembalikan nilai indeks transfer point
   *
   * @param location lokasi transferPoint.
   * @return indeks transfer point
   */
  public boolean equals(Point location) {
    return (getExitPoint().equals(location));
  }
}
