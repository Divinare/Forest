package DataStructures;

public class Node {

    public int key;
    public int height;
    public Node left;
    public Node right;
    public Node parent;
    public Node next;
    public Boolean onkoNull;

    public Node(int key, boolean onkoNull) {
        this.key = key;
        this.onkoNull = onkoNull;
        this.height = 0;
    }

    public int getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getHeight() {
        return height;
    }
}