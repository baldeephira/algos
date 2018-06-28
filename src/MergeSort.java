/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */

 /**
  * This class implements the merge sort algorithm for sorting a given set of numbers.
  * https://www.khanacademy.org/computing/computer-science/algorithms#merge-sort
  * https://www.geeksforgeeks.org/merge-sort/
  * <p>
  * The program uses a fixed array of numbers as input, it can be changed in main method.
  */
public class MergeSort {

  /**
   * Main method used to execute merge sort.  The program used a fixed array of numbers as
   * input.  To change, please update main method and re-compile.  It is meant as an illustrative
   * implementation of the merge sort algorithm.
   *
   * @param args the standard command line arguments are not used.
   */
  public static void main (String[] args) {
    int[] array = {10,23,49,2,49,29,85,14,9,48,60,30};
    System.out.println("Original Array = " + toString(array));
    mergeSort(array);
    System.out.println("Sorted Array   = " + toString(array));
  }

  /**
   * This method sorts the given array of numbers using merge sort algorithm.
   * After the method is done, the given arr will have the sorted data values.
   * @param arr the array of numbers to be sorted.
   */
  static void mergeSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    mergeSortHelper(arr, 0, arr.length -1);
  }

  /**
   * Helper method that implements the merge sort algorithm.  It sorts the given array
   * of data and uses divide and conquer technique.  The arguments index1 and index2
   * are used to keep track of of the sub-array to be sorted by this method.
   * @param arr the array of data values to be sorted.
   * @param index1 the first index that demarcates the sub-array to be sorted (inclusive).
   * @param index2 the last index that demarcates the sub-array to be sorted (inclusive).
   */
  static void mergeSortHelper(int[] arr, int index1, int index2) {
    if (index1 == index2) {
      return;
    }
    int p = index1;
    int r = index2;
    int q = (p + r) / 2;
    mergeSortHelper(arr, p, q);
    mergeSortHelper(arr, q+1, r);
    combine(arr, p, q, r);
  }

  /**
   * Combine method is used to combine two sorted sub-arrays.  The first sub-array is from
   * index p to q (both inclusive).  The second sub-array is from index q+1 to r (both inclusive).
   * The sorted data values will be in given arr after the method is done.
   * @param arr the array of data values to be sorted.
   * @param p the start index of first sub-array (inclusive)
   * @param q the end index of first sub-array (inclusive)
   * @param r the end index of second sub-array (inclusive)
   */
  static void combine(int[] arr, int p, int q, int r) {
    int[] loArr = new int[q - p + 1];
    int[] hiArr = new int[r - (q + 1) + 1];
    for (int i = 0; i < loArr.length; i++) {
      loArr[i] = arr[p+i];
    }
    for (int j = 0; j < hiArr.length; j++) {
      hiArr[j] = arr[q+1+j];
    }
    int i = 0, j = 0, k = p;
    while (i < loArr.length || j < hiArr.length) {
      if (i >= loArr.length) {
        arr[k++] = hiArr[j++];
      } else if (j >= hiArr.length) {
        arr[k++] = loArr[i++];
      } else if (loArr[i] < hiArr[j]) {
        arr[k++] = loArr[i++];
      } else {
        arr[k++] = hiArr[j++];
      }
    }
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