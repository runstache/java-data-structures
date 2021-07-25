package com.lswebworld.structures.lists.single;

public class SingleLinkedList {
  private Node head;

  public Node getHead() {
    return head;
  }

  public void setHead(Node head) {
    this.head = head;
  }

  /**
   * Deletes a Given value from the list.
   * @param key Key to remove
   */
  public boolean delete(int key) {
    Node temp = head;
    Node prev = null;

    if (temp != null && temp.getData() == key) {
      // Head is the one to delete
      head = temp.getNext();
      return true;
    }

    while (temp != null && temp.getData() != key) {
      // Remember the Previous item and set temp to the next
      prev = temp;
      temp = temp.getNext();
    }

    if (temp == null) {
      // Item was not found.
      return false;
    }

    if (prev != null) {
      if (temp.getNext() != null) {
        // Deallocate the Temp item which contains the matched key.
        prev.setNext(temp.getNext());
      } else {
        // If the last item in the list, set it to null
        prev.setNext(null);
      }
    }
    return true;
  }

  /**
   * Adds a Node to the Start of the list.
   * @param data Date Value to add
   */
  public void push(int data) {
    Node newNode = new Node(data);
    newNode.setNext(head);
    head = newNode;
  }

  /**
   * Clears the List.
   */
  public void clear() {
    head = null;
  }

  /**
   * Returns the Size of the Linked List.
   * @return Integer.
   */
  public int size() {
    int count = 0;
    Node temp = head;
    while (temp != null) {
      count++;
      temp = temp.getNext();
    }
    return count;
  }

  /**
   * Recursive Search for the size from a given Node.
   * @param node Start Node.
   * @return Length of the List
   */
  public int size(Node node) {
    if (node == null) {
      return 0;
    }
    return 1 + size(node.getNext());
  }

  /**
   * Returns the Node for the Given Key.
   * @param key Key value
   * @return Node
   */
  public Node find(int key) {

    Node temp = head;
    while (temp != null) {
      if (temp.getData() == key) {
        return temp;
      }
      temp = temp.getNext();
    }
    return null;
  }

  /**
   * Returns the Node based on a start node and key value.
   * @param node Start Node
   * @param key Key value
   * @return Node
   */
  public Node find(Node node, int key) {
    if (node != null) {
      if (node.getData() == key) {
        return node;
      } else {
        return find(node.getNext(), key);
      }
    }
    return null;
  }

  /**
   * Returns the Node at the index starting at the head of the list.
   * @param index Zero based Index Value
   * @return Node
   */
  public Node indexOf(int index) {
    int counter = 0;
    Node temp = head;
    while (temp != null) {
      if (counter == index) {
        return temp;
      }
      counter++;
      temp = temp.getNext();

    }
    return null;
  }

  /**
   * Returns the Node at the 0 based index from the provided Start Node.
   * @param node Start Node
   * @param index 0 Based Index
   * @return Node
   */
  public Node indexOf(Node node, int index) {
    int count = 0;
    if (node != null) {
      if (count == index) {
        return node;
      } else {
        node = node.getNext();
        return indexOf(node, index - 1);
      }
    }
    return null;
  }

  /**
   * Returns the Middle Node from the Linked List.
   * @return Node
   */
  public Node getMiddleNode() {
    if (head != null) {
      Node slow = head;
      Node fast = head;
      while (fast != null && fast.getNext() != null) {
        slow = slow.getNext();
        fast = fast.getNext().getNext();
      }
      return slow;
    } else {
      return null;
    }
  }
}


