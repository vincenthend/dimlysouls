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
        Ninja N = new Ninja("Hatori");

        System.out.println("Testing Health...");
        assertEquals(100,N.getHealth());
        System.out.println("Testing Attack...");
        assertEquals(5,N.getAttack());
        System.out.println("Testing Defense...");
        assertEquals(7,N.getDefense());
        System.out.println("Testing Speed...");
        assertEquals(10,N.getSpeed());
        System.out.println("Testing Level...");
        assertEquals(1,N.getLevel());
        System.out.println("Testing Exp...");
        assertEquals(0,N.getExp());
        System.out.println("Testing Exp for next level...");
        assertEquals(10,N.getNext());
        System.out.println("Testing ClassId...");
        assertEquals(2,N.getClassId());
        System.out.println("Testing player name...");
        assertEquals("Hatori",N.getNama());
    }

    @org.junit.Test
    public void levelUpTest() throws Exception {
        System.out.println("Creating a new Ninja...");
        Ninja N = new Ninja("Hatori");
        System.out.println("Setting player Exp to 35...");
        N.setExp(35);
        assertTrue(N.isLeveling());
        System.out.println("Leveling Up...");
        N.levelUp();
        System.out.println("Re-testing player values...");
        assertEquals(110,N.getHealth());
        assertEquals(6,N.getAttack());
        assertEquals(8,N.getDefense());
        assertEquals(13,N.getSpeed());
        assertEquals(2,N.getLevel());
        assertEquals(25,N.getExp());
        assertEquals(20,N.getNext());
    }
}