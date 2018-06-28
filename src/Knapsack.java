/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */
import java.util.Scanner;

/**
 * Solution for Knapsack problem that is solved using dynamic programming.
 * https://www.geeksforgeeks.org/knapsack-problem/
 */
public class Knapsack {

  /**
   * Main method used to start the program.  It accepts user input from command line
   * and has 2 different solutions.  The first using arrays (as in dynamic programming)
   * and second solution is a recursive solution which is simpler but performs much worse.
   * @param args the standard command line arguments are not used.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("  Welcome to Knapsack Problem!");
    System.out.println("  Enter values separated by comma");
    System.out.print("  Enter item weights:        ");
    String wStr = scanner.next();
    System.out.print("  Enter item values:         ");
    String vStr = scanner.next();
    System.out.print("  Enter knapsack weight:     ");
    int W = scanner.nextInt();
    scanner.close();

    String[] wStrArr = wStr.split(",");
    String[] vStrArr = vStr.split(",");
    int[] weights = new int[wStrArr.length];
    int[] values = new int[vStrArr.length];
    int N = weights.length;

    for (int i=0; i < N; i++) {
      weights[i] = Integer.parseInt(wStrArr[i]);
    }
    for (int i=0; i < N; i++) {
      values[i] = Integer.parseInt(vStrArr[i]);
    }

    System.out.println("  Knapsack value (array):    " + solveUsingArray(weights, values, N, W));
    System.out.println("  Knapsack value (recurse):  " + solveUsingRecursion(weights, values, N, W));
    System.out.println();

  }

  /**
   * Solve the knapsack problem using dynamic programming and construct the
   * 2D array to handle intermediate values used to compute the final value.
   * @param weights the array containing weights of items.
   * @param values the array containing values of items.
   * @param N the total number of items.
   * @param W the capacity of the knapsack.
   * @return the max value that can be put in the knapsack.
   */
  static int solveUsingArray(int[] weights, int[] values, int N, int W) {
    int[][] OPT = new int[N+1][W+1];

    // first row and column are 0s
    // start with 1 item and w=1
    for (int n=1; n <= N; n++) {
      for (int w=1; w <= W; w++) {
        int itemWeight = weights[n-1];   //adjust index
        int itemValue = values[n-1];    //adjust index

        if (itemWeight > w) {
          OPT[n][w] = OPT[n-1][w];
        } else {
          OPT[n][w] = Math.max(OPT[n-1][w], OPT[n-1][w-itemWeight] + itemValue);
        }
      }
    }

    // print the values in OPT
    StringBuilder buf = new StringBuilder("\n");
    for (int w=0; w <= W; w++) {
      buf.append(String.format("%02d", w)).append(" ");
    }
    buf.append("\n\n");
    for (int n=0; n <= N; n++) {
      for (int w=0; w <= W; w++) {
        buf.append(String.format("%02d", OPT[n][w])).append(" ");
      }
      buf.append("\n");
    }
    buf.append("\n");
    System.out.println(buf);

    return OPT[N][W];
  }

  /**
   * Solve the knapsack problem using recursion.
   * @param weights the array containing weights of items.
   * @param values the array containing values of items.
   * @param N the total number of items.
   * @param W the capacity of the knapsack.
   * @return the max value that can be put in the knapsack.
   */
  static int solveUsingRecursion(int[] weights, int[] values, int N, int W) {
    if (N <= 0 || W <= 0) {
      return 0;
    }
    int itemWeight = weights[N-1];
    int itemValue = values[N-1];
    if (itemWeight > W) {
      return solveUsingRecursion(weights, values, N-1, W);
    }
    return Math.max(solveUsingRecursion(weights, values, N-1, W),
                    solveUsingRecursion(weights, values, N-1, W - itemWeight) + itemValue);
  }

}