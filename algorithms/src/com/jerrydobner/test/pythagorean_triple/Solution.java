package com.jerrydobner.test.pythagorean_triple;

import com.jerrydobner.test.pythagorean_triple.solutions.SolutionJD1;
import com.jerrydobner.test.pythagorean_triple.solutions.SolutionJDIter1;
import com.jerrydobner.test.pythagorean_triple.solutions.SolutionJDRecur2;
import com.jerrydobner.test.pythagorean_triple.solutions.SolutionRG1;

/**
 * Created by jdobner on 7/24/2017.
 */
public interface Solution {

  Solution[] ALL_SOLUTIONS = {
      new SolutionJD1(),
      new SolutionRG1(),
      new SolutionJDRecur2(),
      new SolutionJDIter1()};

  Result solve(int perimeter);
}
