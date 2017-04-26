package test;

import static org.junit.Assert.assertEquals;

import model.enemy.Slime;

/**
 * Created by Aspire V5 on 4/26/2017.
 */
public class SlimeTest {

  @org.junit.Test
  public void getAssertions() throws Exception {
    Slime L = new Slime();
    assertEquals(20, L.getHealth());
    assertEquals(10, L.getAttack());
    assertEquals(10, L.getDefense());
    assertEquals(50, L.getSpeed());
    assertEquals(5, L.getExp());
    assertEquals("$", L.getRenderCode());
  }
}