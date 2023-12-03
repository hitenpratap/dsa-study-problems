package dsa.study.problems.linkedlist;

class Node {

    private int data;
    private Node next;

    public Node(int data, Node node) {
        this.data = data;
        this.next = node;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}


public class SinglyLinkedList {

    private Node head;
    private int size;

    public int length() {
        return size;
    }

    public void printList() {
        Node currentNode = head;
        System.out.println("Singly Linked List: ");
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println("\nLength of the list: " + size);
    }

    public void insertAtBeginning(int data) {
        this.head = new Node(data, head);
        size += 1;
    }

    public void insertAtEnd(int data) {
        if (head == null) {
            insertAtBeginning(data);
            return;
        }
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(new Node(data, null));
        size += 1;
    }

    public void insertAtMiddle(int data, int position) {
        if (position < 0 || size < position) {
            throw new IllegalArgumentException("position must be less than length of the list");
        }
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current.getNext();
        }

        Node newNode = new Node(data, current.getNext());
        current.setNext(newNode);
        size += 1;
    }

    public void deleteAtBeginning() {
        if (head == null) {
            throw new IllegalStateException("Linked List is empty");
        }
        head = head.getNext();
        size -= 1;
    }

    public void deleteAtLast() {
        if (head == null) {
            throw new IllegalStateException("Linked List is empty");
        }

        if (head.getNext() == null) {
            head = null;
            size -= 1;
            return;
        }
        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
        size -= 1;
    }

    public void deleteAtMiddle(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException(
                    "position must be greater than or equals to length of the list");
        }

        if (position == 0) {
            deleteAtBeginning();
            return;
        }

        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size -= 1;
    }
}
