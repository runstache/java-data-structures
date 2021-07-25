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
}


