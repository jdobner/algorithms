package com.jerrydobner.test.pythagorean_triple;

import static com.jerrydobner.test.pythagorean_triple.Util.describe;
import static com.jerrydobner.test.pythagorean_triple.Util.println;

import com.jerrydobner.test.pythagorean_triple.solutions.SolutionBruteForce1;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jdobner on 7/26/2017.
 */
public class MiscTest {

  public static void main(String[] args) {
    new MiscTest().solveInRange(0, 2000);
  }



  protected Map<Integer, Result>  solveInRange(int from, int to) {
    Map<Integer, Result> perimToResult = new HashMap<>();

    Solution s = new SolutionBruteForce1();
    for (int p = from; p < to; p++) {
      Result r = s.solve(p);

      if (r.isSolved()) {
        println(describe(p, r));
        Result existing = perimToResult.put(p, r);
        if (! r.test(p)) {
          throw new IllegalArgumentException("INVALID : " + r);
        }

        if (existing != null)
        {
          throw new IllegalArgumentException("Overrides: " + r);
        }

      }
    }
    return perimToResult;
  }

}
