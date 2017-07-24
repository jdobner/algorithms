package com.jerrydobner.test.wwrxercise;

import static java.lang.Math.pow;

/**
 * Created by jdobner on 7/24/2017.
 */
public class SolutionRG1 implements Solution {

  @Override
  public Result solve() {
    int counter = 0;
    for (int c = 1; c < 1000; c++) {
      for (int b = 0; b < c; b++) {
        counter++;
        int k = (1000 - c - b);
        if (k < b && (pow(k, 2) + pow(b, 2) == pow(c, 2))) {
          return new Result(k, b, c, counter);
        }

      }
    }
    throw new IllegalArgumentException("no solution");
  }
}
