package Binarytree;

import DataStructures.LinkedList;

public class Binarytree {

    private Node root;

    public Binarytree(int key) {
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

    public void printLevelOrder() {
//        if (this.root == null) {
//            return;
//        }
        Binarytree binarytree = this;
        LinkedList list = new LinkedList(binarytree.getRoot().key);
        while (list.getSize() != 0) {
            System.out.println(list.getSize());
            System.out.println(list.getHead());
            // Jos jonon päällä on vasen lapsi, laitetaan se jonoon
            if (binarytree.search(binarytree.getRoot(), list.getHead()).left != null) {
                list.add(binarytree.search(binarytree.getRoot(), list.getHead()).left.key);
            }
            // Jos jonon päällä on oikea lapsi, laitetaan se jonoon
            if (binarytree.search(binarytree.getRoot(), list.getHead()).right != null) {
                list.add(binarytree.search(binarytree.getRoot(), list.getHead()).right.key);
            }
            list.removeHead();
            System.out.println("koko " + list.getSize());
            System.out.println("hahaha " + list.getHead());
        }
    }

    public Node getRoot() {
        return root;
    }
}