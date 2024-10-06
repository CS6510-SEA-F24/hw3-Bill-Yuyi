package edu.neu.khoury.cs6510.f24.bill_yuyi;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.function.Consumer;

class BinaryTree {

  public Node root;

  /**
   * Constructor for BinaryTree
   *
   * @param root - Node,given root
   */
  public BinaryTree(Node root) throws IllegalArgumentException{
    if(root == null) {
      throw new IllegalArgumentException("root cannot be null");
    }
    this.root = root;
  }

  /**
   * A method to validate whether a tree is BST or not
   *
   * @return true if the tree is BST else false
   */
  public boolean isBST() {
    Node tmp = root;
    return isBST(tmp, null, null);
  }

  /**
   * A method to calculate the max depth of a tree by using level-order traversal
   *
   * @return Integer, the max depth of the tree
   */
  public Integer getMaxDepth() {
    if (root == null) {
      return 0;
    }

    final int[] depth = {0};
    Consumer<Node> nodeAction = node -> {};

    // Define the levelAction to increment the depth after each level
    Runnable levelAction = () -> depth[0]++;

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
    if (root == null) {
      return null;
    }

    final int[] maxValue = {Integer.MIN_VALUE}; // Holder for the maximum value

    // Define the nodeAction to update the maxValue if current node's value is greater
    Consumer<Node> nodeAction = node -> {
      if (node.val > maxValue[0]) {
        maxValue[0] = node.val;
      }
    };

    Runnable levelAction = () -> {};

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
  private void levelOrderTraversal(Consumer<Node> nodeAction, Runnable levelAction) {
    if (root == null) {
      return;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size(); // Number of nodes at the current level
      for (int i = 0; i < size; i++) {
        Node current = queue.poll();
        nodeAction.accept(current); // Perform the node-specific action

        if (current.left != null) {
          queue.offer(current.left);
        }
        if (current.right != null) {
          queue.offer(current.right);
        }
      }
      levelAction.run(); // Perform the level-specific action
    }
  }

  /**
   * A method to validate the tree is BST or not
   *
   * @param node, Node given current root of the BST
   * @param min,  Integer, min value of those before the current root
   * @param max,  Integer, max value of those before the current root
   * @return boolean, true if it is BST false if not
   */
  private boolean isBST(Node node, Integer min, Integer max) {
    if (node == null)
      return true;
    if (min != null && node.val <= min || max != null && node.val >= max) {
      return false;
    }
    return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
  }

  /**
   * A helper function for insert node to the left.
   *
   * @param node, Node given node to insert
   */
  public void insertLeft(Node node) {
    Node tmp = root;
    while (tmp.left != null) {
      tmp = tmp.left;
    }
    tmp.left = node;
  }


  /**
   * A helper function for insert node to the right.
   *
   * @param node, Node given node to insert
   */
  public void insertRight(Node node) {
    Node tmp = root;
    while (tmp.right != null) {
      tmp = tmp.right;
    }
    tmp.right = node;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BinaryTree that)) {
      return false;
    }
    return root.equals(that.root);
  }

  @Override
  public int hashCode() {
    return Objects.hash(root);
  }
}
