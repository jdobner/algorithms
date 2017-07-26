package com.jerrydobner.test.pythagorean_triple;


/**
 * Created by jdobner on 7/24/2017.
 */
public class SolutionJD1 implements Solution {


  public Result solve(int perimeter) {
    int counter = 0;
    for (int a = 1; a < perimeter; a++) {
      for (int b = a + 1;; b++) {
        counter++;
        int c = perimeter - (a + b);
        if (c <= b) break;
        if (((a * a) + (b * b)) == (c * c)) {
          return new Result(a, b , c, counter);
        }
      }
    }
    return Result.BADRESULT;
  }
}
