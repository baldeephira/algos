/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */
import java.util.*;

/**
 * Solution for TopCoder Quiz Show problem.  There are three players and after playing
 * the game for sometime each has a given score. Each player can put a wager between
 * 0 and current score of player.  Find out the best wager value for third player
 * given the wagers for player 1 and 2.  This is probability based solution.
 */
public class QuizShow {

  /**
   * Main method used to gather user input about current scores and the wagers
   * for player 1 and 2.  It will print out the best wager for player 3.
   * @param args the standard command line arguments are not used.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Lets solve wager problem on Quiz Show");
    System.out.print("Participant Scores (3):    ");
    String scoreStr = scanner.nextLine();
    System.out.print("Wager for Player1:         ");
    String wager1Str = scanner.nextLine();
    System.out.print("Wager for Player2:         ");
    String wager2Str = scanner.nextLine();
    scanner.close();

    int wager1 = Integer.parseInt(wager1Str);
    int wager2 = Integer.parseInt(wager2Str);
    String[] scoreStrArr = scoreStr.split("\\s+");
    int[] scores = new int[scoreStrArr.length];
    for (int i=0; i < scores.length; i++) {
      scores[i] = Integer.parseInt(scoreStrArr[i]);
    }

    System.out.println("Best Wager:                " + wager(scores, wager1, wager2));
  }


  /**
   * Calculate the best wager value for player 3 given the current
   * scores for all 3 players and the wagers for player 1 and 2.
   * @param scores the array of size 3, containing scores for 3 players.
   * @param wager1 the wager value for player 1.
   * @param wager2 the wager value for player 2.
   * @return the best wager value for player 3.
   */
  static int wager(int[] scores, int wager1, int wager2) {
    int wager = -1;
    int bestOdds = -1;
    for (int i=0; i <= scores[0]; i++) {
      int odds = 0;
      for (int a=-1; a<=1; a+=2) {
        for (int b=-1; b<=1; b+=2) {
          for (int c=-1; c<=1; c+=2) {
            int s0 = scores[0] + i * a;
            int s1 = scores[1] + wager1 * b;
            int s2 = scores[2] + wager2 * c;
            if (s0 > s1 && s0 > s2) {
              odds++;
            }
          }
        }
      }
      if (odds > bestOdds) {
        bestOdds = odds;
        wager = i;
      }
    }
    System.out.println("Best Wager Odds:    " + bestOdds);
    return wager;
  }

}