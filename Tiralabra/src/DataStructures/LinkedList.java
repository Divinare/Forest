package DataStructures;

import Binarytree.Node;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length; // emt tarviiks tätä

    public LinkedList(Node uusi) {
//        Node uusi = new Node(key, false);
        this.head = uusi;
        this.tail = uusi;
        this.length = 1;
    }

    public void add(Node uusi) {
//        Node uusi = new Node(key, false);
        if (getSize() == 1) {
            head.next = tail;
        }
        this.tail.next = uusi;
        this.tail = uusi;
        this.length++;
    }

    public void removeHead() {
        this.head = head.next;
        this.length--;
    }

    public int getHeadKey() {
        return head.key;
    }

    public Node getHeadNode() {
        return head;
    }

    public int getSize() {
        return length;
    }
}