/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */
import java.util.Scanner;

/**
 * This class finds the Greatest Common Divisor (GCD) for the two given numbers. The solution is commonly
 * known as Euclid’s algorithm.  This algorithm is much better than brute force method.
 * https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm
 */
public class GCD {

  /**
   * Main method that handles user input for the GCD solution.
   * @param args the standard command line arguments are not used.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("This program will compute GCD of two numbers.");
    System.out.print("Number 1: ");
    String aline = scanner.nextLine();
    System.out.print("Number 2: ");
    String bline = scanner.nextLine();
    int a = Integer.parseInt(aline.trim());
    int b = Integer.parseInt(bline.trim());
    int gcd = gcd(a, b);
    System.out.println("GCD:      " + gcd);
    scanner.close();
  }

  /**
   * Find the GCD for given integers a and b using Euclid's algorith.
   * @param a the first number.
   * @param b the second number.
   * @return the greatest common divisor for a and b.
   */
  private static int gcd(int a, int b) {
    if (a < b) {
      //swap
      int c = a;
      a = b;
      b = c;
    }
    int remainder = a % b;
    if (remainder == 0) {
      return b;
    } else {
      return gcd(b, remainder);
    }
  }

}