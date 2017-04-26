package controller.listener;

import model.map.Map;

/**
 * Interface MapChangeListener, memberikan respon saat terjadi perubahan.
 *
 * @author Mikhael Artur Darmakesuma / 13515099
 */
public interface MapChangeListener {

  /**
   * melakukan aksi ketika map yang digunakan berubah.
   *
   * @param map map yang baru setelah perubahan
   */
  void mapChanged(Map map);
}