package DataStructures;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length; // emt tarviiks tätä

    public LinkedList(int head) {
        Node uusi = new Node(head);
        this.head = uusi;
        this.tail = uusi;
        this.length = 1;
    }

    public void add(int key) {
        Node uusi = new Node(key);
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

    public int getHead() {
        return head.getKey();
    }

    public Node getHeadNode() {
        return head;
    }

    public int getSize() {
        return length;
    }

    private class Node {

        private Node next;
        private int key; // käykö key, vai pitääkö käyttää Object_data?

        public Node(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }
    }
}