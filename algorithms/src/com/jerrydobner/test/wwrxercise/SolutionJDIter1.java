package com.jerrydobner.test.wwrxercise;


import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by jdobner on 7/24/2017.
 */
public class SolutionJDIter1 implements Solution {

  private int counter;

  public Result solve() {
    int counter = 0;

    for (int a = 1; a < 1000; a++) {
      int lo = a + 1, hi = 1000;
      while (lo <= hi) {
        counter++;
        int b = lo + (hi - lo) / 2;
        int c = 1000 - (a + b);
        int diff = (c * c) - ((a * a) + (b * b));
        // diff > 0 means c is too large, b is too small
        if (diff > 0)
          lo = b + 1;
        else if (diff < 0)
          hi = b - 1;
        else
          return new Result(a, b, c, counter);
      }
    }
    return Result.BADRESULT;
  }
}