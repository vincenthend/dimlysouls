package controller.listener;

import model.entity.Entity;

/**
 * Interface Encounter Listener, digunakan untuk menangani adanya encounter
 */
public interface EncounterListener{
  void EncounterFound(Entity e);
}
