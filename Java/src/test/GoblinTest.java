package test;

import static org.junit.Assert.assertEquals;

import model.enemy.Goblin;

/**
 * @author Adrian Mulyana / 13515075
 */
public class GoblinTest {

  @org.junit.Test
  public void getAssertions() throws Exception {
    Goblin G = new Goblin();
    assertEquals(35, G.getHealth());
    assertEquals(15, G.getAttack());
    assertEquals(15, G.getDefense());
    assertEquals(70, G.getSpeed());
    assertEquals(20, G.getExp());
    assertEquals("#", G.getRenderCode());
  }
}