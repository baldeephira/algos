/**
 * MIT License
 * Copyright (c) 2018 Baldeep Hira
 * Contact @ https://bhira.net/
 */
import java.util.Scanner;

/**
 * Implementation for a simple Queue using Node data structure.
 * It supports basic enqueue and dequeue operations.
 */
public class Queue {

  /**
   * Data structure for a node in a queue.
   */
  private static class Node {
    int data;
    Node next;

    /**
     * Constructor for node.
     * @param data the data value for node.
     * @param next the reference to next node in the queue.
     */
    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  // local variables for manage queue state.
  private Node firstNode;
  private Node lastNode;

  /**
   * This enqueque's the given data value at the end of the queue.
   * @param data the data value to be added to the queue.
   */
  public void enqueue(int data) {
    Node node = new Node(data, null);
    if (isEmpty()) {
      this.firstNode = this.lastNode = node;
    } else {
      this.lastNode.next = node;
      this.lastNode = node;
    }
  }

  /**
   * Dequeque an item from the queue and returns its value.
   * @return the value of the item that was removed from queue.
   */
  public int dequeue() {
    if (isEmpty()) {
      return 0;
    } else {
      Node node = this.firstNode;
      if (this.firstNode.next != null) {
        this.firstNode = this.firstNode.next;
      } else {
        this.firstNode = this.lastNode = null;
      }
      return node.data;
    }
  }

  /**
   * Check if the queue is empty.
   * @return true if queue is empty.
   */
  public boolean isEmpty() {
    return (firstNode == null || lastNode == null);
  }


  /**
   * Main method used to execute the program to exercise the queue.
   * It accepts user input from command line and performs operations
   * on the queue and prints the state of the queue after operation.
   * @param args the command line arguments are not used.
   */
  public static void main(String[] args) {
    Queue q = new Queue();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("  Enter operation (q/d):  ");
      String op = scanner.next();
      if (op == null || !(op.equals("q") || op.equals("d"))) {
        System.out.println("    invalid operation");
        continue;
      }
      if (op.equals("q")) {
        System.out.print("  Enter int value:        ");
        int value = scanner.nextInt();
        q.enqueue(value);
      } else {
        int value = q.dequeue();
        System.out.println("  Dequeued value:         " + value);
      }
      System.out.println("    queue = " + q.toString());
    }
  }

  /**
   * Override the toString method for description printing on console.
   * @return the comma separated list of values in the queue.
   */
  public String toString() {
    StringBuilder b = new StringBuilder("[");
    if (this.firstNode != null) {
      boolean first = true;
      Node node = this.firstNode;
      while (node != null) {
        if (first) {
          first = false;
        } else {
          b.append(',');
        }
        b.append(node.data);
        node = node.next;
      }
    }
    b.append(']');
    return b.toString();
  }

}