package edu.neu.khoury.cs6510.f24.billyuyi;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeTest {
  private Node testNode;
  private Node testNode1;

  @BeforeEach
  void setUp() {
    testNode = new Node(2);
    testNode1 = new Node(3, testNode, testNode);
  }

  @Test
  void testEquals() {
    assertEquals(testNode, testNode);
    assertNotEquals(2, testNode);
    assertEquals(testNode, new Node(2));
    assertNotEquals(testNode, testNode1);
    assertEquals(testNode1, new Node(3, testNode, testNode));
    assertNotEquals(testNode1, new Node(3, null, testNode));
    assertNotEquals(testNode1, new Node(3, testNode, null));
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(testNode.getVal(), null, null);
    assertEquals(expectedHash, testNode.hashCode());
  }
}