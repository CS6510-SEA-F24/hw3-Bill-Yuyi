package edu.neu.khoury.cs6510.f24.bill_yuyi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

  private BinaryTree tree;
  private BinaryTree testTree;
  @BeforeEach
  void setUp() {
    Node root = new Node(2);
    tree = new BinaryTree(root);
    tree.insertLeft(new Node(1));
    tree.insertRight(new Node(3));

    testTree = new BinaryTree(new Node(2));
    testTree.insertLeft(new Node(3));
    testTree.insertRight(new Node(4));
  }

  @Test
  void binaryTreeRootIsNullException() {
    assertThrows(IllegalArgumentException.class, () -> {
       new BinaryTree(null);
    });
  }

  @Test
  void isBST() {
    assertTrue(tree.isBST());
    assertFalse(testTree.isBST());
  }

  @Test
  void getMaxDepth() {
    assertEquals(2, tree.getMaxDepth());
  }

  @Test
  void getMaxValInTheTree() {
    assertEquals(3, tree.getMaxValInTheTree());
  }


  @Test
  void testEquals() {
    assertNotEquals(tree, null);
    assertNotEquals(tree, new BinaryTree(new Node(1)));
    assertNotEquals(tree, testTree);
    assertNotEquals(testTree, new BinaryTree(new Node(2, new Node(3), null)));
    assertNotEquals(testTree, new BinaryTree(new Node(2, null, new Node(4))));
    assertNotEquals(tree, 1);
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(new Node(2, new Node(3), new Node(4)));
    assertEquals(testTree.hashCode(), expectedHash);
  }
}