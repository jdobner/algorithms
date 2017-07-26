package com.jerrydobner.test.pythagorean_triple;


/**
 * Created by jdobner on 7/24/2017.
 */
public class SolutionJD2 implements Solution {

  private int counter;

  public Result solve(int perimeter) {
    for (int a = 1; a < perimeter; a++) {
      int start = a + 1;
      int b = findB(perimeter, a, start, start, perimeter - a - start, 0);
      if (b > 0) return new Result(a, b, perimeter - a - b, counter);
    }
    return Result.BADRESULT;
  }



  private int findB(int perimeter, int a, int b, int min, int max, int stackSize) {
    int c =   perimeter - (a + b);
    int k = (c * c) - ((a * a) + (b * b));
    // k > 0 means c is too large, b is too small
    if (stackSize > perimeter) {
      String s ="";
    }

    if (k == 0)
    {
      return b;
    } else if (k > 0) { //search up
      if (b == max) return 0;
      return findB(perimeter, a, b + ((max - b) / 2) , b+1, max, stackSize + 1);
    } else { //search down
      if (b == min) return 0;
      return findB(perimeter, a, b - ((b - min) / 2) , min, b-1, stackSize+1);
    }
  }

}
