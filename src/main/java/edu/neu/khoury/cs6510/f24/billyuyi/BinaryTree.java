package edu.neu.khoury.cs6510.f24.billyuyi;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * A class representing a Binary Tree. This class provides functionality to
 * validate whether the tree is a Binary Search Tree (BST), calculate the
 * maximum depth of the tree, find the maximum value in the tree, and perform
 * basic operations such as inserting nodes to the left or right.
 */
public class BinaryTree {

  private Node root;

  /**
   * Constructor for BinaryTree
   *
   * @param root - Node,given root
   */
  public BinaryTree(final Node root) throws IllegalArgumentException {
    setRoot(root);
  }

  /**
   * A method to validate the tree is BST or not
   *
   * @param node Node given current root of the BST
   * @param min  Integer, min value of those before the current root
   * @param max  Integer, max value of those before the current root
   * @return boolean, true if it is BST false if not
   */
  private boolean isBST(final Node node, final Integer min, final Integer max) {
    boolean isValid = true;

    if (node != null) {
      // Check if current node violates BST property
      if (min != null && node.getVal() <= min || max != null && node.getVal() >= max) {
        isValid = false;
      } else {
        // Recursively check left and right subtrees
        isValid = isBST(node.getLeft(), min, node.getVal()) &&
            isBST(node.getRight(), node.getVal(), max);
      }
    }

    return isValid;
  }

  /**
   * A method to validate whether a tree is BST or not
   *
   * @return true if the tree is BST else false
   */
  public boolean isBST() {
    final Node tmp = root;
    return isBST(tmp, null, null);
  }

  /**
   * A method to calculate the max depth of a tree by using level-order traversal
   *
   * @return Integer, the max depth of the tree
   */
  public Integer getMaxDepth() {

    final int[] depth = {0};
    final Consumer<Node> nodeAction = node -> {};

    // Define the levelAction to increment the depth after each level
    final Runnable levelAction = () -> depth[0]++;

    // Perform the traversal
    levelOrderTraversal(nodeAction, levelAction);

    return depth[0];
  }

  /**
   * A method to get the max value held by tree nodes by using level-order traversal
   *
   * @return Integer, the max value of the tree
   */
  public Integer getMaxValInTheTree() {

    final int[] maxValue = {Integer.MIN_VALUE}; // Holder for the maximum value

    // Define the nodeAction to update the maxValue if current node's value is greater
    final Consumer<Node> nodeAction = node -> {
      if (node.getVal() > maxValue[0]) {
        maxValue[0] = node.getVal();
      }
    };

    final Runnable levelAction = () -> {};

    // Perform the traversal
    levelOrderTraversal(nodeAction, levelAction);

    return maxValue[0];
  }

  /**
   * General level-order traversal method.
   *
   * @param nodeAction  A Consumer that defines the action to perform on each node.
   * @param levelAction A Runnable that defines the action to perform after completing each level.
   */
  private void levelOrderTraversal(final Consumer<Node> nodeAction, final Runnable levelAction) {

    final Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      final int size = queue.size(); // Number of nodes at the current level
      for (int i = 0; i < size; i++) {
        final Node current = queue.poll();
        nodeAction.accept(current); // Perform the node-specific action

        if (current.getLeft() != null) {
          queue.offer(current.getLeft());
        }
        if (current.getRight() != null) {
          queue.offer(current.getRight());
        }
      }
      levelAction.run(); // Perform the level-specific action
    }
  }

  /**
   * A helper function for insert node to the left.
   *
   * @param node Node given node to insert
   */
  public void insertLeft(final Node node) throws IllegalArgumentException {
    if (node == null) {
      throw new IllegalArgumentException("Cannot insert null");
    }
    Node tmp = root;
    while (tmp.getLeft() != null) {
      tmp = tmp.getLeft();
    }
    tmp.setLeft(node);
  }

  /**
   * Retrieves the root node of the binary tree.
   *
   * @return Node - the root of the tree.
   */
  public Node getRoot() {
    return root;
  }

  /**
   * Sets the root node of the binary tree.
   *
   * @param root - Node, the new root node of the tree.
   * @throws IllegalArgumentException if the root is null.
   */
  public void setRoot(final Node root) throws IllegalArgumentException {
    if (root == null) {
      throw new IllegalArgumentException("root cannot be null");
    }
    this.root = root;
  }

  /**
   * A helper function for insert node to the right.
   *
   * @param node Node given node to insert
   */
  public void insertRight(final Node node) throws IllegalArgumentException {
    if (node == null) {
      throw new IllegalArgumentException("Cannot insert null");
    }
    Node tmp = root;
    while (tmp.getRight() != null) {
      tmp = tmp.getRight();
    }
    tmp.setRight(node);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof BinaryTree that)) {
      return false;
    }
    return root.equals(that.root);
  }

  @Override
  public int hashCode() {
    return Objects.hash(root);
  }
}
