package model.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Aspire V5 on 4/26/2017.
 */
public class BerserkerTest {
  @org.junit.Test
  public void getConstructor() throws Exception {
    System.out.println("Creating a new Berserker...");
    Berserker b = new Berserker("Gopnik");

    System.out.println("Testing Health...");
    assertEquals(200, b.getHealth());
    System.out.println("Testing Attack...");
    assertEquals(15, b.getAttack());
    System.out.println("Testing Defense...");
    assertEquals(8, b.getDefense());
    System.out.println("Testing Speed...");
    assertEquals(1, b.getSpeed());
    System.out.println("Testing Level...");
    assertEquals(1, b.getLevel());
    System.out.println("Testing Exp...");
    assertEquals(0, b.getExp());
    System.out.println("Testing Exp for next level...");
    assertEquals(10, b.getNext());
    System.out.println("Testing ClassId...");
    assertEquals(1, b.getClassId());
    System.out.println("Testing player name...");
    assertEquals("Gopnik", b.getNama());
  }

  @org.junit.Test
  public void levelUpTest() throws Exception {
    System.out.println("Creating a new Berserker...");
    Berserker b = new Berserker("Gopnik");
    System.out.println("Setting player Exp to 35...");
    b.setExp(35);
    assertTrue(b.isLeveling());
    System.out.println("Leveling Up...");
    b.levelUp();
    System.out.println("Re-testing player values...");
    assertEquals(220, b.getHealth());
    assertEquals(17, b.getAttack());
    assertEquals(9, b.getDefense());
    assertEquals(2, b.getSpeed());
    assertEquals(2, b.getLevel());
    assertEquals(25, b.getExp());
    assertEquals(20, b.getNext());
  }
}

