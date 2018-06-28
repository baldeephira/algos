/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */
import java.util.Scanner;

/**
 * Implementation of Depth First Search.  The problem statement/explanation can be
 * found here: https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
public class DepthFirstSearch {

  /**
   * Node is a private class representing the data structure for a
   * node in the graph.  The graph traversal is done via nodes.
   */
  private static class Node {
    int data;
    Node[] children;

    /**
     * Constructor for the node. Assuming int value for data.
     * @param data the data value associated with each node.
     */
    Node(int data) {
      this.data = data;
    }

    /**
     * Convenience constructor that can instantiate the node with given
     * data value and also create child nodes with given childVals.  The
     * child nodes are then linked to the parent node.
     */
    Node(int data, int... childVals) {
      this(data);
      if (childVals != null) {
        this.children = new Node[childVals.length];
        for (int i=0; i < childVals.length; i++) {
          this.children[i] = new Node(childVals[i]);
        }
      }
    }
  }


  /**
   * Main method to capture user input for searching
   * different nodes in a graph.  The graph is pre-loaded
   * and the user can choose which values to search for.
   */
  public static void main(String[] args) {
    // init the a bunch of nodes
    Node leaf1 = new Node(12, 45,32,8,90);
    Node leaf2 = new Node(67, 89,2,76,14);
    Node leaf3 = new Node(5, 19,26,99,22);
    Node leaf4 = new Node(56, 76,49,4,62);

    // init a couple of parent nodes and link to child nodes
    Node l1 = new Node(44);
    Node l2 = new Node(33);
    Node[] l1C = {leaf1, leaf2};
    Node[] l2C = {leaf3, leaf4};
    l1.children = l1C;
    l2.children = l2C;

    // init the root nodes and attach child nodes
    Node root = new Node(3);
    Node[] rootC = {l1, l2};
    root.children = rootC;

    // Repeatedly ask for data values to search for and print results
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("Search for: ");
      int value = scanner.nextInt();
      System.out.println("  found = " + dfs(root, value));
    }
  }


  /**
   * Method that implements the depth first search.  It takes the root
   * node of a singlely linked graph and searches for the given value.
   *
   * @param n the root node of the graph.
   * @param val the data value to be searched.
   * @return true if val is found in graph, else false.
   */
  static boolean dfs(Node n, int val) {
    if (n == null) {
      return false;
    }
    if (n.data == val) {
      return true;
    }
    if (n.children != null) {
      for (Node c : n.children) {
        if (dfs(c, val)) {
          return true;
        }
      }
    }
    return false;
  }

}