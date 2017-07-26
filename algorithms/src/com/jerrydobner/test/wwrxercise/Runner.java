package com.jerrydobner.test.wwrxercise;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

/**
 * Created by jdobner on 7/24/2017.
 */
public class Runner{

  private static final int ITERATIONS = 100000;

  public static void main(String[] args) {
    Solution[] solutions = {
        new SolutionJD1(),
        new SolutionRG1(),
        new SolutionJDRecur2(),
        new SolutionJDIter1()};
    new Runner().runAll(solutions);
  }


  private void runAll(Solution[] solutions) {
    for (Solution s : solutions) {
      runOne(s);
    }
  }

  private void runOne(Solution s) {
    out.println("Running " + s.getClass() + " x " + ITERATIONS);

    //Validate solution once
    Result result = s.solve();
    if (result.isValid()) {
      out.println("SOLVED " + s.solve());
    } else {
      throw new IllegalArgumentException(result.toString());
    }

    //now that it's valid, run ITERATIONS times and record timing
    long start = currentTimeMillis();
    for (int i = 0; i < ITERATIONS; i++) {
      s.solve();
    }
    long elapsed = currentTimeMillis() - start;
    out.println("Completed in " + elapsed + "ms");
  }

}
