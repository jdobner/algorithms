package com.jerrydobner.test.pythagorean_triple;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

/**
 * Created by jdobner on 7/24/2017.
 */
public class Runner {
  private static final int ITERATIONS = 10000;


  public void runAll(int perimeter) {
    for (Solution s : Solution.ALL_SOLUTIONS) {
      runOne(s, perimeter);
    }
  }

  public void runOne(Solution s, int perimeter) {
    out.println("Running " + s.getClass() + " x " + ITERATIONS);

    //Validate solution once
    Result result = s.solve(perimeter);
    out.println(result);
    if (!result.test(perimeter)) {
      throw new IllegalArgumentException("NOT VALID reult for " + perimeter + ": " + result);
    }


    //now that it's valid, run ITERATIONS times and record timing
    long start = currentTimeMillis();
    for (int i = 0; i < ITERATIONS; i++) {
      s.solve(perimeter);
    }
    long elapsed = currentTimeMillis() - start;
    out.println("Completed in " + elapsed + "ms");
  }

}
