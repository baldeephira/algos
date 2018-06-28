/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */

/**
 * Factorial class contains implementation for
 * calculating the factorial of a number.
 */
public class Factorial {

  /**
   * Main method that processes user input i.e. the number
   * whose factorial is to be calculated.
   * @param args args[0] contains the input number.
   */
  public static void main (String[] args) {
    if (args == null || args.length <= 0) {
      System.out.println("USAGE: java Factorial <int value>");
      return;
    }
    int n = Integer.parseInt(args[0]);
    System.out.println("Factorial of " + n + " = " + factorial(n));
  }


  /**
   * This calculates the factorial for given integer value n.
   * This is a recursive implementation for factorial.
   *
   * @param n the input number for factorial calculation.
   * @return the factorial value.
   */
  public static int factorial(int n) {
    if (n == 0) {
      return 1;
    }
    return n * factorial(n-1);
  }

}