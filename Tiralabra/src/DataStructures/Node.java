package DataStructures;

public class Node implements Cloneable {

    public int key;
    public int height;
    public Node left;
    public Node right;
    public Node parent;
    public Node next;
    public Boolean onkoNull;
    
    public Node(int key, boolean onkoNull) {
        this.key = key;
        this.height = -1;
        this.onkoNull = onkoNull;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.next = null;

    }

    /**
     * Kloonaa solmun.
     * @return palauttaa kloonatun solmun
     * @throws CloneNotSupportedException 
     */
    public Object clone()
            throws CloneNotSupportedException {
        Node clone = new Node(key, onkoNull);
        if (this.left != null) {
            clone.left = (Node) this.left.clone();
            clone.left.parent = clone;
        }
        if (this.right != null) {
            clone.right = (Node) this.right.clone();
            clone.right.parent = clone;
        }
        return clone;
    }
}