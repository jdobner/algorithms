package com.jerrydobner.test.pythagorean_triple;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

/**
 * Created by jdobner on 7/24/2017.
 */
public class Runner {

  private static final int ITERATIONS = 10000;
  private static final Solution[] SOLUTIONS = {
      new SolutionJD1(),
      new SolutionRG1(),
      new SolutionJDRecur2(),
      new SolutionJDIter1()};

  public static void main(String[] args) {
    new Runner().runAll(SOLUTIONS, 1000);
  }


  private void runAll(Solution[] solutions, int perimeter) {
    for (Solution s : solutions) {
      runOne(s, perimeter);
    }
  }

  private void runOne(Solution s, int perimeter) {
    out.println("Running " + s.getClass() + " x " + ITERATIONS);

    //Validate solution once
    Result result = s.solve(perimeter);
    if (result.isValid()) {
      out.println("SOLVED " + result);
    } else {
      throw new IllegalArgumentException(result.toString());
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
