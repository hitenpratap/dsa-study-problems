package dsa.study.problems.linkedlist;

class DoubleNode {

    private int data;
    private DoubleNode next;
    private DoubleNode prev;

    public DoubleNode(int data, DoubleNode node) {
        this.data = data;
        this.next = node;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }
}


public class DoublyLinkedList {

    private int size;
    private DoubleNode tail;
    private DoubleNode head;

    public int length() {
        return size;
    }

    public void insertAtBeginning(int data) {
        DoubleNode node = new DoubleNode(data, null);
        if (head == null) {
            head = tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        size += 1;
    }

    public void insertAtEnd(int data) {
        DoubleNode node = new DoubleNode(data, null);
        if (head == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size += 1;
    }

    public void insertAtMiddle(int data, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("invalid position");
        }
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        DoubleNode current = head;
        for (int i = 1; i < position; i++) {
            current = current.getNext();
        }
        DoubleNode node = new DoubleNode(data, null);
        node.setNext(current.getNext());
        node.setPrev(current);
        node.getNext().setPrev(node);
        current.setNext(node);
        size += 1;
    }

    public void deleteAtBeginning() {
        if (head == null) {
            throw new IllegalStateException("list is empty!");
        }
        head = head.getNext();
        head.setPrev(null);
        size -= 1;
    }

    public void deleteAtEnd() {
        if (head == null) {
            throw new IllegalStateException("list is empty!");
        }
        tail = tail.getPrev();
        tail.setNext(null);
        size -= 1;
    }

    public void deleteAtMiddle(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("invalid position");
        }
        if (position == 0) {
            deleteAtBeginning();
            return;
        } else if (position == size - 1) {
            deleteAtEnd();
            return;
        }

        DoubleNode current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }

        // current now points to the node just before the one to be deleted
        DoubleNode nodeToDelete = current.getNext();
        DoubleNode nextNode = nodeToDelete.getNext();

        current.setNext(nextNode);
        if (nextNode != null) {
            nextNode.setPrev(current);
        }
        size -= 1;
    }


    public void printList() {
        DoubleNode currentNode = head;
        System.out.print("Doubly Linked List: ");
        while (currentNode != null) {
            System.out.print(currentNode.getData());
            currentNode = currentNode.getNext();
            if (currentNode != null) {
                System.out.print(" <-> ");
            }
        }
        System.out.println();
    }
}
