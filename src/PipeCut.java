/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */
import java.util.*;

/**
 * Solution for the TopCoder Pipe Cut problem.
 */
public class PipeCut {

  /**
   * Main method used to gather user input and prints the results.
   * @param args the standard command line arguments are not used.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Lets solve the Pipe Cut problem");
    System.out.print("Weld Locations:    ");
    String weldStr = scanner.nextLine();
    System.out.print("Desired Length:    ");
    String lengthStr = scanner.nextLine();
    scanner.close();

    int L = Integer.parseInt(lengthStr);
    String[] weldStrArr = weldStr.split("\\s+");
    int[] welds = new int[weldStrArr.length];
    for (int i=0; i<weldStrArr.length; i++) {
      welds[i] = Integer.parseInt(weldStrArr[i]);
    }

    System.out.println("Probability:     " + probability(welds, L));
  }

  /**
   * Calculates the probability that one of the cut sections
   * will have length greater than L.
   * @param welds an array containing weld points in the pipe.
   * @param L the length against which the cuts will be compared.
   * @return the probability that cut section is longer than L.
   */
  static double probability(int[] welds, int L) {
    int tOdds = 0;
    int pOdds = 0;
    for (int i=0; i<welds.length; i++) {
      for (int j=i+1; j<welds.length; j++) {
        int c1 = welds[i];
        int c2 = welds[j];
        if (c1 > c2) {
          c1 = c2;
          c2 = welds[i];
        }
        int l1 = c1;
        int l2 = c2 - c1;
        int l3 = 100 - l1 - l2;
        if (l1 > L || l2 > L || l3 > L) {
          pOdds++;
        }
        tOdds++;
      }
    }
    return ((double)pOdds) / tOdds;
  }

}