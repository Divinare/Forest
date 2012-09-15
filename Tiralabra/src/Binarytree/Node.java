package Binarytree;


public class Node {

    public int key;
    public Node left;
    public Node right;
    public Node parent;
    public Boolean onkoNull;
    
    public Node(int key, boolean onkoNull) {  
        this.key = key;
        this.onkoNull = onkoNull;
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
}