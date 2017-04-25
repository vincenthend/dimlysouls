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
        Paladin P = new Paladin("Purist");

        System.out.println("Testing Health...");
        assertEquals(200,P.getHealth());
        System.out.println("Testing Attack...");
        assertEquals(10,P.getAttack());
        System.out.println("Testing Defense...");
        assertEquals(15,P.getDefense());
        System.out.println("Testing Speed...");
        assertEquals(2,P.getSpeed());
        System.out.println("Testing Level...");
        assertEquals(1,P.getLevel());
        System.out.println("Testing Exp...");
        assertEquals(0,P.getExp());
        System.out.println("Testing Exp for next level...");
        assertEquals(10,P.getNext());
        System.out.println("Testing ClassId...");
        assertEquals(3,P.getClassId());
        System.out.println("Testing player name...");
        assertEquals("Purist",P.getNama());
    }

    @org.junit.Test
    public void levelUpTest() throws Exception {
        System.out.println("Creating a new PaladiP...");
        Paladin P = new Paladin("Purist");
        System.out.println("Setting player Exp to 35...");
        P.setExp(35);
        assertTrue(P.isLeveling());
        System.out.println("Leveling Up...");
        P.levelUp();
        System.out.println("Re-testing player values...");
        assertEquals(220,P.getHealth());
        assertEquals(12,P.getAttack());
        assertEquals(16,P.getDefense());
        assertEquals(3,P.getSpeed());
        assertEquals(2,P.getLevel());
        assertEquals(25,P.getExp());
        assertEquals(20,P.getNext());
    }
}