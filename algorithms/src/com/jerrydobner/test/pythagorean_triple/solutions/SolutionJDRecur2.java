package com.jerrydobner.test.pythagorean_triple.solutions;


import static java.lang.Math.max;
import static java.lang.Math.min;

import com.jerrydobner.test.pythagorean_triple.Counter;
import com.jerrydobner.test.pythagorean_triple.Result;
import com.jerrydobner.test.pythagorean_triple.Solution;

/**
 * Created by jdobner on 7/24/2017.
 */
public class SolutionJDRecur2 implements Solution {

  public Result solve(int perimeter) {
    Counter counter = new Counter();
    for (int a = 1; a < perimeter; a++) {
      int start = a + 1;
      int b = findB(perimeter, a, start, perimeter - a - start, 0, counter);
      if (b > 0) return Result.solved(a, b, perimeter - a - b, counter.getIterations());
    }
    return Result.unsolved(counter.getIterations());
  }


  private int findB(int perimeter, int a, int point1, int point2, int stackSize, Counter counter) {
    counter.increment();
    int b = point1 + ((point2 - point1) / 2);
    if (b == point1 || b == point2) return 0;
    int c = perimeter - (a + b);
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
      return findB(perimeter, a, b, p2, stackSize + 1, counter);
    }
  }

}
