/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */
import java.util.*;

/**
 * Implementation of in-place reversal of a linked list.
 * It defines the Node structure and and implements a
 * method used to reverse the list.
 */
public class ReverseList {

  /**
   * Data structure for node in a singlely linked list.
   */
  public class Node {
    int data;
    Node next;
  }


  /**
   * This method reverses the linked list with given root node.
   * @param root the root node of the linked list.
   */
  public void reverse(Node root) {
    if (root == null) {
      return;
    }
    Node n = root, p = null;

    while (n != null) {
      Node t = n;
      n = n.next;
      t.next = p;
      p = t;
    }
  }

}