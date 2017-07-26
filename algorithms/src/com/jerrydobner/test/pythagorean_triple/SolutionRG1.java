package com.jerrydobner.test.pythagorean_triple;

/**
 * Created by jdobner on 7/24/2017.
 */
public class SolutionRG1 implements Solution {

  @Override
  public Result solve(int perimeter) {
    int counter = 0;
    for (int c = 1; c < perimeter; c++) {
      for (int b = 0; b < c; b++) {
        counter++;
        int a = (1000 - c - b);
        if (a < b && (a * a + b * b == c * c)) {
          return new Result(a, b, c, counter);
        }

      }
    }
    return Result.BADRESULT;
  }

}
