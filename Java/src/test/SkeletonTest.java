package test;

import static org.junit.Assert.assertEquals;

import model.enemy.Skeleton;

/**
 * Created by Aspire V5 on 4/26/2017.
 */
public class SkeletonTest {
  @org.junit.Test
  public void getAssertions() throws Exception {
    Skeleton S = new Skeleton();
    assertEquals(50, S.getHealth());
    assertEquals(25, S.getAttack());
    assertEquals(15, S.getDefense());
    assertEquals(35, S.getSpeed());
    assertEquals(45, S.getExp());
    assertEquals("X", S.getRenderCode());
  }
}