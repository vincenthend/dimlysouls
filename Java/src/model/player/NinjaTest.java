package model.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Aspire V5 on 4/26/2017.
 */
public class NinjaTest {

  @org.junit.Test
  public void getConstructor() throws Exception {
    System.out.println("Creating a new Ninja...");
    Ninja n = new Ninja("Hatori");

    System.out.println("Testing Health...");
    assertEquals(100, n.getHealth());
    System.out.println("Testing Attack...");
    assertEquals(5, n.getAttack());
    System.out.println("Testing Defense...");
    assertEquals(7, n.getDefense());
    System.out.println("Testing Speed...");
    assertEquals(10, n.getSpeed());
    System.out.println("Testing Level...");
    assertEquals(1, n.getLevel());
    System.out.println("Testing Exp...");
    assertEquals(0, n.getExp());
    System.out.println("Testing Exp for next level...");
    assertEquals(10, n.getNext());
    System.out.println("Testing ClassId...");
    assertEquals(2, n.getClassId());
    System.out.println("Testing player name...");
    assertEquals("Hatori", n.getNama());
  }

  @org.junit.Test
  public void levelUpTest() throws Exception {
    System.out.println("Creating a new Ninja...");
    Ninja n = new Ninja("Hatori");
    System.out.println("Setting player Exp to 35...");
    n.setExp(35);
    assertTrue(n.isLeveling());
    System.out.println("Leveling Up...");
    n.levelUp();
    System.out.println("Re-testing player values...");
    assertEquals(110, n.getHealth());
    assertEquals(6, n.getAttack());
    assertEquals(8, n.getDefense());
    assertEquals(13, n.getSpeed());
    assertEquals(2, n.getLevel());
    assertEquals(25, n.getExp());
    assertEquals(20, n.getNext());
  }
}