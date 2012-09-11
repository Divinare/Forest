package AVLtree;

public class Node {

    int key;
    int height;
    Node left;
    Node right;
    Node parent;
    
    public Node(int key) {  
        this.key = key;
        this.height = 0; // ?????
    }
    public int getKey() {
        return key;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public Node getLeft() {
        return left;
    }
    public Node getRight() {
        return right;
    }
}