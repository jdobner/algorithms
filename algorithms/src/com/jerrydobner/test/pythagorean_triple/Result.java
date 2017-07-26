package com.jerrydobner.test.pythagorean_triple;

/**
 * Created by jdobner on 7/24/2017.
 */
public class Result {
  private final boolean isSolved;
  public final int a;
  public final int b;
  public final int c;
  public final int iterations;


  public static Result solved(int a, int b, int c, int iterations) {
    return new Result(true, a, b , c, iterations);
  }

  public static Result unsolved(int iterations) {
    return new Result(false, 0, 0, 0, iterations);
  }

  private Result(boolean isSolved, int a, int b, int c, int iterations) {
    this.isSolved = isSolved;
    this.a = a;
    this.b = b;
    this.c = c;
    this.iterations = iterations;
  }


  @Override
  public String toString() {
    String prefix = isSolved() ? "" : "!!UN";
    return prefix + "SOLVED: a=" + a + ", b=" + b + ", c=" + c + " cycles=" + iterations;
  }

  public boolean isSolved() {
    return this.isSolved;
  }


  public boolean test(int perimeter) {
    return !isSolved() || (a < b && b < c && a+b+c == perimeter && a*a + b*b == c*c);
  }




}
