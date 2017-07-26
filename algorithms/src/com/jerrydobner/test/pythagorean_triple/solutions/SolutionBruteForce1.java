package com.jerrydobner.test.pythagorean_triple.solutions;


import com.jerrydobner.test.pythagorean_triple.Result;
import com.jerrydobner.test.pythagorean_triple.Solution;

/**
 * Created by jdobner on 7/24/2017.
 */
public class SolutionBruteForce1 implements Solution {


  public Result solve(int perimeter) {
    int counter = 0;
    for (int a = 1; a < perimeter; a++) {
      for (int b = a + 1;; b++) {
        counter++;
        int c = perimeter - (a + b);
        if (c <= b) break;
        if (((a * a) + (b * b)) == (c * c)) {
          return Result.solved(a, b , c, counter);
        }
      }
    }
    return Result.unsolved(counter);
  }
}
