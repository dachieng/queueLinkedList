import java.util.NoSuchElementException;

import javax.naming.directory.NoSuchAttributeException;

public class LinkedListDeque {
    private Node head;
    private Node tail;
    private int length;

    LinkedListDeque() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // linked list
    public class Node {
        public Node next;
        public Node previous;
        public String data;

        Node(String data) {
            this.data = data;
        }

    }

    public boolean isEmpty() {
        // queue is empty if the size = 0
        return length == 0;
    }

    public int length() {
        // find the size of the queue
        return length;
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        //
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }

        tail = newNode;
        length++;
    }

    public Node removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node tempNode = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        tempNode.next = null;
        length--;
        return tempNode;
    }

    public Node removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node tempNode = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        tempNode.previous = null;
        length--;
        return tempNode;
    }

    public void display() {
        if (head == null) {
            return;
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

    }

    public int size() {
        return length;
    }

    public Node first() {
        if (isEmpty()) {
            throw new RuntimeException("No element");
        }
        return head;
    }

    public Node last() {
        if (isEmpty()) {
            throw new RuntimeException("No element");
        }
        return tail;
    }

}
