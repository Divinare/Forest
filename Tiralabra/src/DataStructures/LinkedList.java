package DataStructures;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length; // emt tarviiks tätä

    public LinkedList(int head) {
        this.head = new Node(head);
        this.tail = new Node(head);
        this.length = 1;
    }
    
    public void add(int key) {
        Node uusi = new Node(key);
        if (head == tail) {
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