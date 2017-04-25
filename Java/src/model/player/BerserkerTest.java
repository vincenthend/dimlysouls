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
        Berserker B = new Berserker("Gopnik");

            System.out.println("Testing Health...");
            assertEquals(200,B.getHealth());
            System.out.println("Testing Attack...");
            assertEquals(15,B.getAttack());
            System.out.println("Testing Defense...");
            assertEquals(8,B.getDefense());
            System.out.println("Testing Speed...");
            assertEquals(1,B.getSpeed());
            System.out.println("Testing Level...");
            assertEquals(1,B.getLevel());
            System.out.println("Testing Exp...");
            assertEquals(0,B.getExp());
            System.out.println("Testing Exp for next level...");
            assertEquals(10,B.getNext());
            System.out.println("Testing ClassId...");
            assertEquals(1,B.getClassId());
            System.out.println("Testing player name...");
            assertEquals("Gopnik",B.getNama());
        }

    @org.junit.Test
    public void levelUpTest() throws Exception {
        System.out.println("Creating a new Berserker...");
        Berserker B = new Berserker("Gopnik");
        System.out.println("Setting player Exp to 35...");
        B.setExp(35);
        assertTrue(B.isLeveling());
        System.out.println("Leveling Up...");
        B.levelUp();
        System.out.println("Re-testing player values...");
        assertEquals(220,B.getHealth());
        assertEquals(17,B.getAttack());
        assertEquals(9,B.getDefense());
        assertEquals(2,B.getSpeed());
        assertEquals(2,B.getLevel());
        assertEquals(25,B.getExp());
        assertEquals(20,B.getNext());
        }
    }

