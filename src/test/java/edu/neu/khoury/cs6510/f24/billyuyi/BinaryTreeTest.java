package edu.neu.khoury.cs6510.f24.billyuyi;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Objects;

class BinaryTreeTest {

  private BinaryTree tree;
  private BinaryTree testTree;

  private BinaryTree testTree1;

  @BeforeEach
  void setUp() {
    Node root = new Node(2);
    tree = new BinaryTree(root);
    tree.insertLeft(new Node(1));
    tree.insertRight(new Node(3));

    testTree = new BinaryTree(new Node(2));
    testTree.insertLeft(new Node(3));
    testTree.insertRight(new Node(4));

    testTree1 = new BinaryTree(new Node(3));
    testTree1.insertRight(new Node(4));
    testTree1.insertRight(new Node(5));
    testTree1.insertLeft(new Node(10));
    testTree1.insertLeft(new Node(7));
  }

  @Test
  void binaryTreeNodeIsNullException() {
    assertThrows(IllegalArgumentException.class, () -> {
       new BinaryTree(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      testTree1.insertLeft(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      testTree1.insertRight(null);
    });
  }

  @Test
  void isBST() {
    BinaryTree t = new BinaryTree(new Node(10));
    t.insertLeft(new Node(2));
    t.insertRight(new Node(15));
    t.insertLeft(new Node(3));
    assertFalse(t.isBST());
    t = new BinaryTree(new Node(10));
    t.insertLeft(new Node(3));
    t.insertRight(new Node(9));
    assertFalse(t.isBST());
    assertTrue(new BinaryTree(new Node(2)).isBST());
    assertTrue(tree.isBST());
    assertFalse(testTree.isBST());
    assertFalse(testTree1.isBST());
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
    assertEquals(tree, tree);
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(new Node(2, new Node(3), new Node(4)));
    assertEquals(testTree.hashCode(), expectedHash);
  }
}