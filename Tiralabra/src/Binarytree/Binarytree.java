package Binarytree;

public class Binarytree {

    private Node root;

    public Binarytree(int key) {
        this.root = new Node(key);
    }

//    public void lol() {
//        Node x = new Node(5);
//        Node y = new Node(7);
//        Node z = new Node(10);
//        Node m = new Node(2);
//        root.left = x;
//        root.left.right = y;
//        root.left.left = m;
//        root.left.left.left = z;
//    }
    
    public void insert(int key) {
        Node uusi = new Node(key);
        if (root == null) {
            root = uusi;
            return;
        }
        Node x = root;
        Node p = x;
        while (x != null) {
            p = x;
            if (key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        uusi.parent = p;


        if (uusi.key < p.key) {
            p.left = uusi;
        } else {
            p.right = uusi;
        }

    }

    public Node search(Node x, int key) {
        if (x == null || x.key == key) {
            return x;
        }
        if (key < x.key) {
            return search(x.left, key);
        } else {
            return search(x.right, key);
        }
    }

    public int min(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x.key;
    }

    public int max(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x.key;
    }

    public void printInOrder(Node x) {
        if (x != null) {
            printInOrder(x.left);
            System.out.println(x.key);
            printInOrder(x.right);
        }
    }

    public void printPreOrder(Node x) {
        if (x != null) {
            System.out.println(x.key);
            printPreOrder(x.left);
            printPreOrder(x.right);

        }
    }

    public Node getRoot() {
        return root;
    }
}