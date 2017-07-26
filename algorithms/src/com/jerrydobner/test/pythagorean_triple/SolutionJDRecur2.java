package com.jerrydobner.test.pythagorean_triple;


import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by jdobner on 7/24/2017.
 */
public class SolutionJDRecur2 implements Solution {

  private int counter;

  public Result solve(int perimeter) {
    Counter counter = new Counter();
    for (int a = 1; a < 1000; a++) {
      int start = a + 1;
      int b = findB(a, start, 1000 - a - start, 0, counter);
      if (b > 0) return new Result(a, b, perimeter - a - b, counter.getIterations());
    }
    return Result.BADRESULT;
  }


  private Result solve(int point1, int point2, Counter counter) {
    return null;
  }



  private int findB(int a, int point1, int point2, int stackSize, Counter counter) {
    counter.inCrement();
    int b = point1 + ((point2 - point1) / 2);
    if (b == point1 || b == point2) return 0;
    int c = 1000 - (a + b);
    int diff = (c * c) - ((a * a) + (b * b));
    // diff > 0 means c is too large, b is too small
    if (stackSize > 20) {
      String s ="";
    }

    if (diff == 0) {
      return b;
    }
    else {
      int p2 = diff > 0 ? max(point1, point2) : min(point1, point2);
      return findB(a, b, p2, stackSize + 1, counter);
    }
  }

  private class Counter {
    int iterations;

    void inCrement() {
      iterations++;
    }

    int getIterations() {
      return iterations;
    }


  }

}
