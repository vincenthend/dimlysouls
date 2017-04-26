package test;

import static org.junit.Assert.assertEquals;

import model.enemy.Minotaur;

/**
 * Created by Aspire V5 on 4/26/2017.
 */
public class MinotaurTest {

  @org.junit.Test
  public void getAssertions() throws Exception {
    Minotaur M = new Minotaur();
    assertEquals(100, M.getHealth());
    assertEquals(45, M.getAttack());
    assertEquals(60, M.getDefense());
    assertEquals(15, M.getSpeed());
    assertEquals(100, M.getExp());
    assertEquals("!", M.getRenderCode());
  }
}