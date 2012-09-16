package Binarytree;

import DataStructures.LinkedList;

public class Binarytree {

    private Node root;
    private int vapaaLuku;

    public Binarytree(int key) {
        this.root = new Node(key, false);
        this.vapaaLuku = 50;
    }

    public void insert(int key) {
        Node uusi = new Node(key, false);
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

    public int laskeKorkeus(Node x) {
        if (x == null) {
            return -1;
        }
        int k1 = laskeKorkeus(x.left);
        int k2 = laskeKorkeus(x.right);
        return Math.max(k1, k2) + 1;
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
        Binarytree binarytree = this;
        LinkedList list = new LinkedList(binarytree.getRoot().key);
        while (list.getSize() != 0) {
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
        }
    }

    public void printTree() {
        // tehdään "täydellinen" binääripuu
        Binarytree binarytree = teePuustaTaydellinen(this, laskeKorkeus(this.getRoot()));
        System.out.println("kokeillaa " + binarytree.search(binarytree.getRoot(), 52).key);

        LinkedList list = new LinkedList(binarytree.getRoot().key);
        while (list.getSize() != 0) {
            System.out.println(list.getHead());
            // Jos jonon päällä on vasen lapsi, laitetaan se jonoon
            System.out.println("HEAD ON " + list.getHead());
            System.out.println("onko root null? " + binarytree.getRoot().key);
            System.out.println("kokeillaan etsiä: " + binarytree.search(binarytree.getRoot(), list.getHead()).left);
            if (binarytree.search(binarytree.getRoot(), list.getHead()).left != null) {
                list.add(binarytree.search(binarytree.getRoot(), list.getHead()).left.key);
            }
            // Jos jonon päällä on oikea lapsi, laitetaan se jonoon
            if (binarytree.search(binarytree.getRoot(), list.getHead()).right != null) {
                list.add(binarytree.search(binarytree.getRoot(), list.getHead()).right.key);
            }
            list.removeHead();
        }
    }

    private Binarytree teePuustaTaydellinen(Binarytree tree, int korkeus) {
        int tamanHetkinenKorkeus = korkeus;
        int solmujenMaara = 1;
        int korkeudenLaskemisraja = 1;
        LinkedList list = new LinkedList(tree.getRoot().key);
        System.out.println("lololol " + tree.getRoot().key);
        while (list.getSize() != 0 && tamanHetkinenKorkeus >= 0) {
            // Jos jonon päällä on vasen lapsi, laitetaan se jonoon
            if (tree.search(tree.getRoot(), list.getHead()).left != null) {
                System.out.println("laitetaan " + tree.search(tree.getRoot(), list.getHead()).left.key);
                list.add(tree.search(tree.getRoot(), list.getHead()).left.key);
                solmujenMaara++;
            }
            // Laitetaan feikkilapsi jos lasta ei ole
            if (tree.search(tree.getRoot(), list.getHead()).left == null) {
                tree.search(tree.getRoot(), list.getHead()).left = new Node(etsiVapaaLuku(tree.getRoot()), true);
                System.out.println("laitetaan " + tree.search(tree.getRoot(), list.getHead()).left.key);
                list.add(tree.search(tree.getRoot(), list.getHead()).left.key);
                solmujenMaara++;
            }
            // Jos jonon päällä on oikea lapsi, laitetaan se jonoon
            if (tree.search(tree.getRoot(), list.getHead()).right != null) {
                System.out.println("laitetaan " + tree.search(tree.getRoot(), list.getHead()).right.key);
                list.add(tree.search(tree.getRoot(), list.getHead()).right.key);
                solmujenMaara++;
            }
            // Laitetaan feikkilapsi jos lasta ei ole
            if (tree.search(tree.getRoot(), list.getHead()).right == null) {
                tree.search(tree.getRoot(), list.getHead()).right = new Node(etsiVapaaLuku(tree.getRoot()), true);
                System.out.println("laitetaan " + tree.search(tree.getRoot(), list.getHead()).right.key);
                list.add(tree.search(tree.getRoot(), list.getHead()).right.key);
                solmujenMaara++;
            }
            list.removeHead();
            if (korkeudenLaskemisraja <= solmujenMaara) {
                korkeudenLaskemisraja = korkeudenLaskemisraja * 2 + 1;
                tamanHetkinenKorkeus--;
            }
        }

        return tree;
    }

    public int etsiVapaaLuku(Node x) {
//        int vapaaLuku = 0;
//        boolean loytyi = false;
//        while (loytyi == false) {
//            if (search(x, vapaaLuku) == null) {
//                loytyi = true;
//            } else {
//                vapaaLuku++;
//            }
//        }
//        return vapaaLuku;
        vapaaLuku++;
        return vapaaLuku;
    }

    public Node getRoot() {
        return root;
    }
}