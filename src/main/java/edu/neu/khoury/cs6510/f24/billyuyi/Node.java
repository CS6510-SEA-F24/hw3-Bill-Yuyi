package edu.neu.khoury.cs6510.f24.billyuyi;

import java.util.Objects;

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

  public int getVal() {
    return val;
  }

  public Node getLeft() {
    return left;
  }

  public Node getRight() {
    return right;
  }

  public void setVal(final int val) {
    this.val = val;
  }

  public void setLeft(final Node left) {
    this.left = left;
  }

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