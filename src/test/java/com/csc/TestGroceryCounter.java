package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

  GroceryCounter counter;

  @BeforeEach
  void setUp() {
    counter = new GroceryCounter();
  }

      @Test
      public void testinitial() {
          assertEquals("$00.00", counter.total());
      }
  
      @Test
      public void testtens() {
          counter.tens();
          assertEquals("$10.00", counter.total());
      }
  
      @Test
      public void testones() {
          counter.ones();
          assertEquals("$01.00", counter.total());
      }
  
      @Test
      public void testtenths() {
          counter.tenths();
          assertEquals("$00.10", counter.total());
      }
  
      @Test
      public void testhundreths() {
          counter.hundreths();
          assertEquals("$00.01", counter.total());
      }
  
      @Test
      public void testoverflow() {
          for (int i = 0; i < 10000; i++) {
              counter.hundreths();
          }
          assertEquals("$00.00", counter.total());
          assertEquals(1, counter.number_of_overflows());
      }
  
      @Test
      public void testclear() {
          counter.tens();
          counter.ones();
          counter.clear();
          assertEquals("$00.00", counter.total());
          assertEquals(0, counter.number_of_overflows());
      }
  
      @Test
      public void testmany() {
          counter.ones();
          counter.ones();
          counter.tenths();
          counter.hundreths();
          assertEquals("$02.11", counter.total());
      }
  
  @Test
  void itWorks() {
    assertEquals(true, true);
  }
}