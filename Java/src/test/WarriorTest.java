package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import model.player.Warrior;

/**
 * Created by Aspire V5 on 4/26/2017.
 */
public class WarriorTest {

  @org.junit.Test
  public void getConstructor() throws Exception {
    System.out.println("Creating a new Warrior...");
    Warrior w = new Warrior("Davion");

    System.out.println("Testing Health...");
    assertEquals(150, w.getHealth());
    System.out.println("Testing Attack...");
    assertEquals(10, w.getAttack());
    System.out.println("Testing Defense...");
    assertEquals(10, w.getDefense());
    System.out.println("Testing Speed...");
    assertEquals(4, w.getSpeed());
    System.out.println("Testing Level...");
    assertEquals(1, w.getLevel());
    System.out.println("Testing Exp...");
    assertEquals(0, w.getExp());
    System.out.println("Testing Exp for next level...");
    assertEquals(10, w.getNext());
    System.out.println("Testing ClassId...");
    assertEquals(4, w.getClassId());
    System.out.println("Testing player name...");
    assertEquals("Davion", w.getNama());
  }

  @org.junit.Test
  public void levelUpTest() throws Exception {
    System.out.println("Creating a new Warrior...");
    Warrior w = new Warrior("Davion");
    System.out.println("Setting player Exp to 35...");
    w.setExp(15);
    assertTrue(w.isLeveling());
    System.out.println("Leveling Up...");
    w.levelUp();
    System.out.println("Re-testing player values...");
    assertEquals(165, w.getHealth());
    assertEquals(12, w.getAttack());
    assertEquals(12, w.getDefense());
    assertEquals(5, w.getSpeed());
    assertEquals(2, w.getLevel());
    assertEquals(5, w.getExp());
    assertEquals(20, w.getNext());
  }
}