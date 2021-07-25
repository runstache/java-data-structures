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


}