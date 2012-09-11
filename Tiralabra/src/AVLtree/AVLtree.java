package AVLtree;

public class AVLtree {

    private Node root;

    public AVLtree(int key) {
        this.root = new Node(key);
    }

    public void insert(int key) {
        Node uusi = new Node(key);
        if (root == null) {
            root = uusi;
            return;
        }
        Node x = root;
        Node p = x;
//    int height = 0;
        while (x != null) {
//         height++;
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
// check if balanced
    }

    public int getHeight(Node x) {
        if (x == null) {
            return -1;
        } else {
            return x.height;
        }
    }
    
    public Node RightRotate(Node k1) {
        Node k2 = k1.left;
        k2.parent = k1.parent;
        k1.parent = k2;
        k1.left = k2.right;
        k2.right = k1;
        if (k1.left != null) {
            k1.left.parent = k1;
        }
        k1.height = Math.max( getHeight(k1.left), getHeight(k1.right)) +1;
        k2.height = Math.max( getHeight(k2.left), getHeight(k2.right)) +1;
        return k2;
    }
    
    public void LeftRotate(Node x) {
        
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