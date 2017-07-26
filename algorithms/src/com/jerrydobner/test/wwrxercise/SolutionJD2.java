package com.jerrydobner.test.wwrxercise;


/**
 * Created by jdobner on 7/24/2017.
 */
public class SolutionJD2 implements Solution {

  private int counter;

  public Result solve() {
    for (int a = 1; a < 1000; a++) {
      int start = a + 1;
      int b = findB(a, start, start, 1000 - a - start, 0);
      if (b > 0) return new Result(a, b, 1000 - a - b, counter);
    }
    return Result.BADRESULT;
  }



  private int findB(int a, int b, int min, int max, int stackSize) {
    int c = 1000 - (a + b);
    int k = (c * c) - ((a * a) + (b * b));
    // k > 0 means c is too large, b is too small
    if (stackSize > 1000) {
      String s ="";
    }

    if (k == 0)
    {
      return b;
    } else if (k > 0) { //search up
      if (b == max) return 0;
      return findB(a, b + ((max - b) / 2) , b+1, max, stackSize + 1);
    } else { //search down
      if (b == min) return 0;
      return findB(a, b - ((b - min) / 2) , min, b-1, stackSize+1);
    }
  }

}
