/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */

 /**
  * This class implements the selection sort algorithm for sorting a given set of numbers.
  * https://www.khanacademy.org/computing/computer-science/algorithms#sorting-algorithms
  * https://www.geeksforgeeks.org/selection-sort/
  * <p>
  * The program uses a fixed array of numbers as input, it can be changed in main method.
  */
public class SelectionSort {

  /**
   * Main method used to execute selection sort.  The program used a fixed array of numbers as
   * input.  To change, please update main method and re-compile.  It is meant as an illustrative
   * implementation of the selection sort algorithm.
   *
   * @param args the standard command line arguments are not used.
   */
  public static void main (String[] args) {
    int[] array = {10,23,49,2,49,29,85,14,9,48,60,30};
    System.out.println("Original Array = " + toString(array));
    selectionSort(array);
    System.out.println("Sorted Array   = " + toString(array));
  }

  /**
   * This method sorts the given array of numbers using selection sort algorithm.
   * It does an in-place sort, the input array will be have sorted results.
   * @param arr the array of numbers to be sorted.
   */
  static void selectionSort(int[] arr) {
    if (arr == null || arr.length <= 0) {
      return;
    }
    int endIndex = arr.length - 1;
    for (int i=0; i <= endIndex; i++) {
      int minIndex = indexOfMinValueInRange(arr, i, endIndex);
      swap(arr, i, minIndex);
    }
  }

  /**
   * Find the index of the element with minimum value in the range
   * demarcated by startIndex and endIndex (both inclusive).
   * @param arr the array containing data values
   * @param startIndex the first element of range (inclusive).
   * @param endIndex the last element of range (inclusive).
   * @return the index of the element that has minimum vaulue in range.
   */
  static int indexOfMinValueInRange(int[] arr, int startIndex, int endIndex) {
    int minIndex = startIndex;
    for (int i = startIndex+1; i <= endIndex; i++) {
      if (arr[i] < arr[minIndex]) {
        minIndex = i;
      }
    }
    return minIndex;
  }

  /**
   * Swap the values at index1 and index2 in given array.
   * @param arr the array containing data values.
   * @param index1 the index of first element.
   * @param index2 the index of second element.
   */
  static void swap(int[] arr, int index1, int index2) {
    if (arr == null || index1 < 0 || index2 < 0 || index1 == index2) {
      return;
    }
    int tempValue = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = tempValue;
  }

  /**
   * Helper method that is used to convert an array into comma separated list.
   * @param arr the array containing data values.
   * @return the comma separated list of values in the array.
   */
  static String toString(int[] arr) {
    StringBuilder b = new StringBuilder("[");
    if (arr != null && arr.length > 0) {
      for (int i=0; i < arr.length; i++) {
        if (i != 0) {
          b.append(',');
        }
        b.append(arr[i]);
      }
    }
    b.append("]");
    return b.toString();
  }

}