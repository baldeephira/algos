/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */

 /**
  * This class implements the quick sort algorithm for sorting a given set of numbers.
  * https://www.khanacademy.org/computing/computer-science/algorithms#quick-sort
  * https://www.geeksforgeeks.org/quick-sort/
  * <p>
  * The program uses a fixed array of numbers as input, it can be changed in main method.
  */
public class QuickSort {

  /**
   * Main method used to execute quick sort.  The program used a fixed array of numbers as
   * input.  To change, please update main method and re-compile.  It is meant as an illustrative
   * implementation of the quick sort algorithm.
   *
   * @param args the standard command line arguments are not used.
   */
  public static void main (String[] args) {
    int[] array = {10,23,49,2,49,29,85,14,9,48,60,30};
    System.out.println("Original Array = " + toString(array));
    invokeSort(array);
    System.out.println("Sorted Array   = " + toString(array));
  }

  /**
   * This method sorts the given array of numbers using quick sort algorithm.
   * It does an in-place sort, the input array will be have sorted results.
   * @param arr the array of numbers to be sorted.
   */
  static void invokeSort(int[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }
    quicksort(arr, 0, arr.length-1);
  }

  /**
   * The method that sorts the array range demarcated by indices p and q (both inclusive).
   * It is a recursive implementation of quicksort that uses in-place array to sort items.
   * After the method is finished, the given array will have the sorted data items.
   * @param arr the array of data values.
   * @param p the start index (inclusive).
   * @param q the end index (inclusive).
   */
  static void quicksort(int[] arr, int p, int r) {
    if (p >= r) {
      return;
    }
    int q = partition(arr, p, r);
    quicksort(arr, p, q-1);
    quicksort(arr, q+1, r);
  }

  /**
   * Partition the array into two and return the partition point.  This is needed so that
   * quicksort can use the divide and conquer strategy to sorted items in smaller sub-arrays.
   * The partition method ensures that the pivot element returned by it is at the correct
   * sorted position in the array.
   * @param arr the array of data values.
   * @param p the start index (inclusive).
   * @param q the end index (inclusive).
   */
  static int partition(int[] arr, int p, int r) {
    int pivot = arr[r];
    int q = p;
    for (int j = p; j < r; j++) {
      if (arr[j] <= pivot) {
        swap(arr, q, j);
        q++;
      }
    }
    swap(arr, q, r);
    return q;
  }

  /**
   * Swap the values at index1 and index2 in given array.
   * @param arr the array containing data values.
   * @param index1 the index of first element.
   * @param index2 the index of second element.
   */
  static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
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