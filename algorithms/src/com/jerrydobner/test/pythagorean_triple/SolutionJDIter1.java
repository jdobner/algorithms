package com.jerrydobner.test.pythagorean_triple;


import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by jdobner on 7/24/2017.
 */
public class SolutionJDIter1 implements Solution {

  private int counter;

  public Result solve(int perimeter) {
    int counter = 0;

    for (int a = 1; a < perimeter; a++) {
      int lo = a + 1, hi = perimeter;
      while (lo <= hi) {
        counter++;
        int b = lo + (hi - lo) / 2;
        int c = perimeter - (a + b);
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