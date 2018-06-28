/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */
import java.util.Scanner;

/**
 * BirthdayOdds class is an implementation of the solution for Birthday Odds problem
 * as described here: http://mathforum.org/dr.math/faq/faq.birthdayprob.html
 */
public class BirthdayOdds {

  /**
   * Main method that handles user input and invokes the worker method to
   * calculate the minimum number of people required in a group so that
   * the odds of two people having same birthday is x% (%minOdd) and the
   * common assumption is #days ~= 365.
   *
   * @param args the command line arguments are not used.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Lets solve birthday odds problem!");
    System.out.print("Min Odds %:      ");
    int minOdds = scanner.nextInt();
    System.out.print("Days in Year:    ");
    int numDays = scanner.nextInt();
    scanner.close();

    System.out.println("Min People:      " + minPeople(minOdds, numDays));
  }

  /**
   * Find the minimum number of people required in a group so that
   * the odds of two people having same birthday is minOddsPct.
   *
   * @param minOddsPct the minimum odds percentage.
   * @param numDays the number of days in a year (365 or 366).
   * @return the number of people needed in a group.
   */
  private static int minPeople(int minOddsPct, int numDays) {
    double targetP = 1 - ((double)minOddsPct) / 100;
    double probabilty = 1;
    int count = 0;
    while (probabilty > targetP) {
      probabilty *= ((double)(numDays - count)) / numDays;
      count++;
    }
    return count;
  }

}