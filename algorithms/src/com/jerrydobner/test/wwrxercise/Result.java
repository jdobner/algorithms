package com.jerrydobner.test.wwrxercise;

/**
 * Created by jdobner on 7/24/2017.
 */
public class Result {
  public final int a;
  public final int b;
  public final int c;
  public final int iterations;


  public Result(int a, int b, int c, int iterations) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.iterations = iterations;
  }

  @Override
  public String toString() {
    return "a=" + a + ", b=" + b + ", c=" + c + " cycles=" + iterations;
  }

  public void log()
  {
    if (a < b && b < c && a+b+c == 1000 && a*a + b*b == c*c) {
      System.out.println("SOLVED " + this);
    } else {
      throw new IllegalArgumentException(this.toString());
    }
  }

}
