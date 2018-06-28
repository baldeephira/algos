/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */
import java.util.Scanner;

/**
 * This class implements the solution for Egg Drop problem.  Problem description:
 * https://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 * and an alternate one at https://brilliant.org/wiki/egg-dropping/
 */
public class EggDrop {


  /**
   * Main method that handles user input for the egg drop solution
   * @param args the standard command line arguments are not used.
   */
  public static void main(String[] args) {
    int eggs, floors;
    Scanner scanner = new Scanner(System.in);
    System.out.println("  Egg Drop problem...");
    System.out.print("  Enter number of eggs:      ");
    eggs = scanner.nextInt();
    System.out.print("  Enter number of floors:    ");
    floors = scanner.nextInt();
    System.out.println("  Min drops:                 " + minDrops(eggs, floors));
    System.out.println("  Min drops (recursive):     " + minDropsRecursive(eggs, floors));
    scanner.close();
  }

  /**
   * This method finds the minimum number of drops needed to find out the floor from
   * which the egg breaks when dropped.  It has an iterative implementation to the
   * problem and can scale to large number of floors (input).
   *
   * @param eggs the number of eggs available.
   * @param floors the number of floors in the building.
   * @return the minimum number of drops needed to find the floor at which egg breaks.
   */
  private static int minDrops(int eggs, int floors) {
    int[][] OPT = new int[eggs+1][floors+1];

    // fill in sequential values for 1 egg
    for (int x = 0; x <= floors; x++) {
      OPT[1][x] = x;
    }

    // start with 2 eggs and floor=1
    for (int e = 2; e <= eggs; e++) {
      for (int f = 1; f <= floors; f++) {
        int val = Integer.MAX_VALUE;
        for (int x = 1; x <= f; x++) {
          int ival = 1 + Math.max(OPT[e-1][x-1], OPT[e][f-x]);
          val = Math.min(val, ival);
        }
        OPT[e][f] = val;
      }
    }
    return OPT[eggs][floors];
  }

  /**
   * This method finds the minimum number of drops needed to find out the floor from
   * which the egg breaks when dropped.  This is recursive implementation to the egg
   * drop problem and has an exponential call stack.  It takes forever with floors > 30
   *
   * @param eggs the number of eggs available.
   * @param floors the number of floors in the building.
   * @return the minimum number of drops needed to find the floor at which egg breaks.
   */
  private static int minDropsRecursive(int eggs, int floors) {
    if (eggs == 1 || floors == 0 || floors == 1) {
      return floors;
    }
    int drops = 10000;
    for (int x = 1; x <= floors; x++) {
      int dx = 1 + Math.max(minDropsRecursive(eggs-1, x-1), minDropsRecursive(eggs, floors - x));
      drops = Math.min(drops, dx);
    }
    return drops;
  }

}