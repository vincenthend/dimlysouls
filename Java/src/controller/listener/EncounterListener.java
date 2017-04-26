package controller.listener;

import model.entity.Entity;

/**
 * Interface Encounter Listener, digunakan untuk menangani adanya encounter.
 *
 * @author Mikhael Artur Darmakesuma / 13515099
 */
public interface EncounterListener {
  /**
   * Menemukan entity pada map.
   *
   * @param e entity yang ditemukan
   */
  void encounterFound(Entity e);
}
