package controller.listener;

import model.map.Map;

/**
 * Interface MapChangeListener, memberikan respon saat terjadi perubahan.
 */
public interface MapChangeListener {
  /**
   * melakukan aksi ketika map yang digunakan berubah.
   * @param map map yang baru setelah perubahan
   */
  void mapChanged(Map map);
}