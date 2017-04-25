package model.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Aspire V5 on 4/26/2017.
 */
public class WarriorTest {
    @org.junit.Test
    public void getConstructor() throws Exception {
        System.out.println("Creating a new Warrior...");
        Warrior W = new Warrior("Davion");

        System.out.println("Testing Health...");
        assertEquals(150,W.getHealth());
        System.out.println("Testing Attack...");
        assertEquals(10,W.getAttack());
        System.out.println("Testing Defense...");
        assertEquals(10,W.getDefense());
        System.out.println("Testing Speed...");
        assertEquals(4,W.getSpeed());
        System.out.println("Testing Level...");
        assertEquals(1,W.getLevel());
        System.out.println("Testing Exp...");
        assertEquals(0,W.getExp());
        System.out.println("Testing Exp for next level...");
        assertEquals(10,W.getNext());
        System.out.println("Testing ClassId...");
        assertEquals(4,W.getClassId());
        System.out.println("Testing player name...");
        assertEquals("Davion",W.getNama());
    }

    @org.junit.Test
    public void levelUpTest() throws Exception {
        System.out.println("Creating a new Warrior...");
        Warrior W = new Warrior("Davion");
        System.out.println("Setting player Exp to 35...");
        W.setExp(35);
        assertTrue(W.isLeveling());
        System.out.println("Leveling Up...");
        W.levelUp();
        System.out.println("Re-testing player values...");
        assertEquals(165,W.getHealth());
        assertEquals(12,W.getAttack());
        assertEquals(12,W.getDefense());
        assertEquals(5,W.getSpeed());
        assertEquals(2,W.getLevel());
        assertEquals(25,W.getExp());
        assertEquals(20,W.getNext());
    }
}