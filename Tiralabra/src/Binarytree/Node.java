package Binarytree;


public class Node {

    int key;
    Node left;
    Node right;
    Node parent;
    
    public Node(int key) {  
        this.key = key;
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