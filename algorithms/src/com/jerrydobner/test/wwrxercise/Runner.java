package com.jerrydobner.test.wwrxercise;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

/**
 * Created by jdobner on 7/24/2017.
 */
public class Runner{

  private static final int ITERATIONS = 1000;

  public static void main(String[] args) {
    Solution[] solutions = {new SolutionJD1(), new SolutionRG1()};
    new Runner().runAll(solutions);
  }


  private void runAll(Solution[] solutions) {
    for (Solution s : solutions) {
      runOne(s);
    }
  }

  private void runOne(Solution s) {
    out.println("Running " + s.getClass() + " x " + ITERATIONS);
    s.solve().log();
    long start = currentTimeMillis();
    for (int i = 0; i < ITERATIONS; i++) {
      s.solve();
    }
    long elapsed = currentTimeMillis() - start;
    out.println("Completed in " + elapsed + "ms");
  }

}
