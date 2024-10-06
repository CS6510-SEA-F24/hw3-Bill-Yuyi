package edu.neu.khoury.cs6510.f24.billyuyi;

import java.util.Objects;


/**
 * A class representing a Node in a binary tree structure. Each node contains
 * an integer value and references to its left and right child nodes. The node
 * can be used to build binary trees for various data structures and algorithms.
 */
public class Node {
  private int val;
  private Node left;
  private Node right;

  /**
   * Constructor for Node
   *
   * @param val - Integer,given value
   * @param left    - Node,given left Node
   * @param right     - Node, given left node
   */
  public Node(final int val, final Node left, final Node right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  /**
   * Constructor for Node
   *
   * @param val - Integer,given value
   */
  public Node(final int val) {
    this.val = val;
  }

  /**
   * Retrieves the value of this node.
   *
   * @return the integer value of this node.
   */
  public int getVal() {
    return val;
  }

  /**
   * Retrieves the left child node of this node.
   *
   * @return the left child node, or null if there is no left child.
   */
  public Node getLeft() {
    return left;
  }

  /**
   * Retrieves the right child node of this node.
   *
   * @return the right child node, or null if there is no right child.
   */
  public Node getRight() {
    return right;
  }

  /**
   * Sets the value of this node.
   *
   * @param val - Integer, the new value of this node.
   */
  public void setVal(final int val) {
    this.val = val;
  }

  /**
   * Sets the left child node of this node.
   *
   * @param left - Node, the new left child node.
   */
  public void setLeft(final Node left) {
    this.left = left;
  }

  /**
   * Sets the right child node of this node.
   *
   * @param right - Node, the new right child node.
   */
  public void setRight(final Node right) {
    this.right = right;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Node node)) {
      return false;
    }
    return val == node.val && Objects.equals(left, node.left) && Objects.equals(
        right, node.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, left, right);
  }
}