package model.enemy;

/**
 * Created by Aspire V5 on 4/25/2017.
 */

import static org.junit.Assert.assertEquals;
public class GoblinTest{

    @org.junit.Test
    public void getAssertions() throws Exception {
        Goblin G = new Goblin();
        assertEquals(35,G.getHealth());
        assertEquals(15,G.getAttack());
        assertEquals(15,G.getDefense());
        assertEquals(70,G.getSpeed());
        assertEquals(20,G.getExp());
        assertEquals("#",G.getRenderCode());
    }

}