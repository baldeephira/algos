/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */

 /**
  * Class used to check if a given string is a palindrome (same as you read
  * simultaneously from left and right).  It uses recursion for this check.
  */
 public class Palindrome {

  /**
   * Main method used to execute the palindrome check. It prompts
   * for user input and uses that to perform the palindrome check.
   * @param args the standard command line arguments are not used.
   */
  public static void main (String[] args) {
    if (args == null || args.length <= 0) {
      System.out.println("USAGE: java Factorial <string>");
      return;
    }
    String s = args[0];
    System.out.println("IS PALINDROME  " + s + " = " + isPalindrome(s));
  }

  /**
   * Method used to check if the given string is a palindrome.
   * @param s the string to be evaluated.
   * @return true if the given string is a palindrome.
   */
  static boolean isPalindrome(String s) {
    if (s == null || s.length() <= 1) {
      return true;
    }
    return isPalindromeHelper(s, 0, s.length());
  }

  /**
   * Helper method that uses recursion to check if the given string s
   * is a palindrome. It performs an equi-distant character check.
   * @param s the string being evaluated.
   * @param distance the distance of char from center of s.
   * @param length the length of the string s
   * @return true if the string is a palindrome.
   */
  static boolean isPalindromeHelper(String s, int distance, int length) {
    if (distance >= length/2) {
      return true;
    }
    if (s.charAt(distance) != s.charAt(length-1-distance)) {
      return false;
    }
    return isPalindromeHelper(s, distance+1, length);
  }

}