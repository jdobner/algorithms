package com.jerrydobner.test.pythagorean_triple;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jdobner on 7/26/2017.
 */
public class InteractiveSingleTest {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Perimeter: ");
    String line = br.readLine().trim();
    new Runner().runAll(Integer.parseInt(line));
  }

}
