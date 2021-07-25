package com.lswebworld.structures.lists.single;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SingleLinkedListTest {

  @Test
  void testPushThreeNodes() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);


    List<Integer> values = new ArrayList<>();

    Node head = list.getHead();
    while (head != null) {
      values.add(head.getData());
      head = head.getNext();
    }

    assertThat(values).hasSize(3);
    assertThat(values).containsExactly(3,2,1);
  }

  @Test
  void testDeleteItem() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);

    assertThat(list.delete(2)).isTrue();
    List<Integer> values = new ArrayList<>();

    Node head = list.getHead();
    while (head != null) {
      values.add(head.getData());
      head = head.getNext();
    }

    assertThat(values).hasSize(2);
    assertThat(values).containsExactly(3,1);
  }

  @Test
  void testDeleteHead() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);

    assertThat(list.delete(1)).isTrue();

    List<Integer> values = new ArrayList<>();
    Node head = list.getHead();
    while (head != null) {
      values.add(head.getData());
      head = head.getNext();
    }
    assertThat(values).hasSize(2).containsExactly(3,2);

  }

  @Test
  void testDeleteKeyNotPresent() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);

    assertThat(list.delete(4)).isFalse();

    List<Integer> values = new ArrayList<>();
    Node head = list.getHead();
    while (head != null) {
      values.add(head.getData());
      head = head.getNext();
    }
    assertThat(values).hasSize(3).containsExactly(3,2,1);
  }

  @Test
  void testClearList() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);

    list.clear();

    assertThat(list.getHead()).isNull();
  }

  @Test
  void testSize() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);

    assertThat(list.size()).isEqualTo(3);
  }

  @Test
  void testSizeRecusive() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);

    assertThat(list.size(list.getHead())).isEqualTo(3);

    assertThat(list.size(list.getHead().getNext())).isEqualTo(2);

    assertThat(list.size(null)).isEqualTo(0);
  }

  @Test
  void testFindByValue() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);

    assertThat(list.size()).isEqualTo(3);

    Node node = list.find(3);
    assertThat(node).isNotNull();
    assertThat(node.getData()).isEqualTo(3);

  }

  @Test
  void testFindByNode() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);

    Node node = list.find(list.getHead(), 2);

    assertThat(node).isNotNull();
    assertThat(node.getData()).isEqualTo(2);
  }

  @Test
  void testFindNotPresent() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);
    Node node = list.find(4);

    assertThat(node).isNull();
  }

  @Test
  void testFindNotPresentRecursive() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);
    Node node = list.find(list.getHead(), 4);
    assertThat(node).isNull();
  }

  @Test
  void testIndexOf() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);
    list.push(4);

    Node node = list.indexOf(2);

    assertThat(node).isNotNull();
    assertThat(node.getData()).isEqualTo(2);
  }

  @Test
  void testIndexOfStartNode() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);
    list.push(4);

    Node node = list.indexOf(list.getHead(), 3);

    assertThat(node).isNotNull();
    assertThat(node.getData()).isEqualTo(1);

  }

  @Test
  void testIndexOfNoValueAtIndex() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);

    Node node = list.indexOf(4);
    assertThat(node).isNull();
  }

  @Test
  void testIndexOfRecursiveNoValue() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);

    Node node = list.indexOf(list.getHead(), 5);
    assertThat(node).isNull();
  }

  @Test
  void testGetMiddleEven() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);
    list.push(4);

    Node node = list.getMiddleNode();
    assertThat(node).isNotNull();
    assertThat(node.getData()).isEqualTo(2);
  }

  @Test
  void testGetMiddleOdd() {
    SingleLinkedList list = new SingleLinkedList();

    list.setHead(new Node(1));
    list.push(2);
    list.push(3);
    list.push(4);
    list.push(5);

    Node node = list.getMiddleNode();
    assertThat(node).isNotNull();
    assertThat(node.getData()).isEqualTo(3);
  }

}