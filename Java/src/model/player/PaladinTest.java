package model.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Aspire V5 on 4/26/2017.
 */
public class PaladinTest {

  @org.junit.Test
  public void getConstructor() throws Exception {
    System.out.println("Creating a new PaladiP...");
    Paladin p = new Paladin("Purist");

    System.out.println("Testing Health...");
    assertEquals(200, p.getHealth());
    System.out.println("Testing Attack...");
    assertEquals(10, p.getAttack());
    System.out.println("Testing Defense...");
    assertEquals(15, p.getDefense());
    System.out.println("Testing Speed...");
    assertEquals(2, p.getSpeed());
    System.out.println("Testing Level...");
    assertEquals(1, p.getLevel());
    System.out.println("Testing Exp...");
    assertEquals(0, p.getExp());
    System.out.println("Testing Exp for next level...");
    assertEquals(10, p.getNext());
    System.out.println("Testing ClassId...");
    assertEquals(3, p.getClassId());
    System.out.println("Testing player name...");
    assertEquals("Purist", p.getNama());
  }

  @org.junit.Test
  public void levelUpTest() throws Exception {
    System.out.println("Creating a new PaladiP...");
    Paladin p = new Paladin("Purist");
    System.out.println("Setting player Exp to 35...");
    p.setExp(35);
    assertTrue(p.isLeveling());
    System.out.println("Leveling Up...");
    p.levelUp();
    System.out.println("Re-testing player values...");
    assertEquals(220, p.getHealth());
    assertEquals(12, p.getAttack());
    assertEquals(16, p.getDefense());
    assertEquals(3, p.getSpeed());
    assertEquals(2, p.getLevel());
    assertEquals(25, p.getExp());
    assertEquals(20, p.getNext());
  }
}