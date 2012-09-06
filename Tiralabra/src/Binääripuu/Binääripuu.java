package Binääripuu;

public class Binääripuu {

    private Node root;

    public Binääripuu(int key) {
        this.root = new Node(key);
    }

    public void insert(int key) {
        Node uusi = new Node(key);
        if (root == null) {
            root = uusi;
            return;
        }
        Node x = root;
        while (x != null) {
            Node p = x;
            if (key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
            uusi.parent = p;
            if (key < p.key) {
                p.left = uusi;
            } else {
                p.right = uusi;
            }
        }
    }
}
