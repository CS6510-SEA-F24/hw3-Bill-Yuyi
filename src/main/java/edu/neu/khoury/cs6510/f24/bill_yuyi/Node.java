package edu.neu.khoury.cs6510.f24.bill_yuyi;

import java.util.Objects;

public class Node {
  public int val;
  public Node left;
  public Node right;

  /**
   * Constructor for Node
   *
   * @param val - Integer,given value
   * @param left    - Node,given left Node
   * @param right     - Node, given left node
   */
  public Node(int val, Node left, Node right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  /**
   * Constructor for Node
   *
   * @param val - Integer,given value
   */
  public Node(int val) {
    this.val = val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Node node)) {
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