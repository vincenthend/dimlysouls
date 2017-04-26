package test;

import model.enemy.Slime;

import static org.junit.Assert.assertEquals;

/**
 * Created by Aspire V5 on 4/26/2017.
 */
public class SlimeTest {

  @org.junit.Test
  public void getAssertions() throws Exception {
    Slime L = new Slime();

    assertEquals(100, L.getHealth());
    assertEquals(11, L.getAttack());
    assertEquals(3, L.getDefense());
    assertEquals(50, L.getSpeed());
    assertEquals(5, L.getExp());
    assertEquals("$", L.getRenderCode());
  }
}