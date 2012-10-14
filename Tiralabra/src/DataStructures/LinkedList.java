package DataStructures;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    /**
     * Konstruktori alustaa linkitetyn listan, laittaa headiksi sekä tailiksi
     * parametrinä annetun solmun ja asettaa pituudeksi yhden.
     * @param uusi solmu, joka asetetaan listan headiksi ja tailiksi
     */
    public LinkedList(Node uusi) {
        this.head = uusi;
        this.tail = uusi;
        this.length = 1;
    }
    /**
     * Lisää listaan tailiksi parametrinä annetun solmun ja kasvattaa listan pituutta.
     * @param uusi solmu, joka halutaan lisätä listaan
     */
    public void add(Node uusi) {
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