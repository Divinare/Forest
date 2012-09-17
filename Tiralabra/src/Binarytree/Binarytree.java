package Binarytree;

import DataStructures.LinkedList;

public class Binarytree {

    private Node root;

    public Binarytree(int key) {
        this.root = new Node(key, false);
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
        LinkedList list = new LinkedList(binarytree.getRoot());
        Node nykyinen = list.getHeadNode();
        while (list.getSize() != 0) {
            System.out.println(list.getHeadKey());
            // Jos jonon päällä on vasen lapsi, laitetaan se jonoon
            if (nykyinen.left != null) {
                list.add(nykyinen.left);
            }
            // Jos jonon päällä on oikea lapsi, laitetaan se jonoon
            if (nykyinen.right != null) {
                list.add(nykyinen.right);
            }
            list.removeHead();
            nykyinen = list.getHeadNode();
        }
    }

    public void printTree() {
        // tehdään "täydellinen" binääripuu
        Binarytree binarytree = teePuustaTaydellinen(this, laskeKorkeus(this.getRoot()));

        LinkedList list = new LinkedList(binarytree.getRoot());
        Node nykyinen = list.getHeadNode();
        while (list.getSize() != 0) {
            System.out.println(list.getHeadKey());
            // Jos jonon päällä on vasen lapsi, laitetaan se jonoon
            if (nykyinen.left != null) {
                list.add(nykyinen.left);
            }
            // Jos jonon päällä on oikea lapsi, laitetaan se jonoon
            if (nykyinen.right != null) {
                list.add(nykyinen.right);
            }
            list.removeHead();
            nykyinen = list.getHeadNode();
        }
    }

    private Binarytree teePuustaTaydellinen(Binarytree tree, int korkeus) {
        int tamanHetkinenKorkeus = korkeus;
        int solmujenMaara = 1;
        int korkeudenLaskemisraja = 1;
        LinkedList list = new LinkedList(tree.getRoot());
        Node nykyinen = list.getHeadNode();
        while (list.getSize() != 0 && tamanHetkinenKorkeus >= 0) {
            // Jos jonon päällä on vasen lapsi, laitetaan se jonoon
            if (nykyinen.left != null) {
                list.add(nykyinen.left);
                solmujenMaara++;
            }
            // Laitetaan feikkilapsi jos lasta ei ole
            if (nykyinen.left == null) {
//                tree.search(tree.getRoot(), list.getHeadKey()).left = new Node(etsiVapaaLuku(tree.getRoot()), true);
                nykyinen.left = new Node(nykyinen.key-1, true);
                list.add(nykyinen.left);
                solmujenMaara++;
            }
            // Jos jonon päällä on oikea lapsi, laitetaan se jonoon
//            vanha: if (tree.search(tree.getRoot(), list.getHeadKey()).right != null) {
            if (nykyinen.right != null) {
                list.add(nykyinen.right);
                solmujenMaara++;
            }
            // Laitetaan feikkilapsi jos lasta ei ole
            if (nykyinen.right == null) {
//                tree.search(tree.getRoot(), list.getHeadKey()).right = new Node(etsiVapaaLuku(tree.getRoot()), true);
//                System.out.println("LAITETAAN  " + tree.search(tree.getRoot(), list.getHeadKey()).right.key+1);
                nykyinen.right = new Node(nykyinen.key+1, true);
                list.add(nykyinen.right);
                solmujenMaara++;
            }
            list.removeHead();
            nykyinen = list.getHeadNode();
            if (korkeudenLaskemisraja <= solmujenMaara) {
                korkeudenLaskemisraja = korkeudenLaskemisraja * 2 + 1;
                tamanHetkinenKorkeus--;
            }
        }

        return tree;
    }

    public Node getRoot() {
        return root;
    }
}