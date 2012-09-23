package AVLtree;

import DataStructures.Node;
import DataStructures.LinkedList;

public class AVLtree {

    private Node root;

    public AVLtree(int key) {
        this.root = new Node(key, false);
    }

    public void AVLinsert(int key) {
        Node uusi = insert(key);
        Node p = uusi.parent;
        // Tarkistetaan menikö puu epätasapainoon, jos meni niin suoritetaan tarvittavat kierrot
        while (p != null) {
            Node alipuu;
            int vasemmanKorkeus = 0;
            int oikeanKorkeus = 0;
            if (p.left != null) {
                vasemmanKorkeus = p.left.height;
            }
            if (p.right != null) {
                oikeanKorkeus = p.right.height;
            }
            // Aiheuttaako vanhemman vasen lapsi epätasapainon
            if (vasemmanKorkeus == oikeanKorkeus + 2) {
                Node vanhempi = p.parent;
                int vasemmanVasemmanKorkeus = 0;
                int vasemmanOikeanKorkeus = 0;
                if (p.left.left != null) {
                    vasemmanVasemmanKorkeus = p.left.left.height;
                }
                if (p.left.right != null) {
                    vasemmanOikeanKorkeus = p.left.right.height;
                }
                // onko syy vasemman lapsen vasemmassa vai oikeassa alipuussa?
                if (vasemmanVasemmanKorkeus > vasemmanOikeanKorkeus) {
                    alipuu = rightRotate(p);
                } else {
                    alipuu = leftRightRotate(p);
                }
                if (vanhempi == null) {
                    this.root = alipuu;
                } else if (vanhempi.left == p) {
                    vanhempi.left = alipuu;
                } else {
                    vanhempi.right = alipuu;
                }
                if (vanhempi != null) {
                    vanhempi.height = laskeKorkeus(vanhempi);
                }
                return;
            }
            // Aiheuttaako vanhemman oikea lapsi epätasapainon
            if (oikeanKorkeus == vasemmanKorkeus + 2) {
                Node vanhempi = p.parent;
                int oikeanOikeanKorkeus = 0;
                int oikeanVasemmanKorkeus = 0;
                if (p.right.right != null) {
                    oikeanOikeanKorkeus = p.right.right.height;
                }
                if (p.right.left != null) {
                    oikeanVasemmanKorkeus = p.right.left.height;
                }
                // onko syy vasemman lapsen oikeassa vai vasemmassa alipuussa?
                if (oikeanOikeanKorkeus > oikeanVasemmanKorkeus) {
                    alipuu = leftRotate(p);
                } else {
                    alipuu = rightLeftRotate(p);
                }
                if (vanhempi == null) {
                    this.root = alipuu;
                } else if (vanhempi.left == p) {
                    vanhempi.left = alipuu;
                } else {
                    vanhempi.right = alipuu;
                }
                if (vanhempi != null) {
                    vanhempi.height = laskeKorkeus(vanhempi);
                }
                return;
            }
            p.height = laskeKorkeus(p);
            p = p.parent; // jatketaan kohti juurta
        }
    }

    public Node insert(int key) {
        Node uusi = new Node(key, false);
        if (root == null) {
            root = uusi;
            return uusi;
        }
        Node x = root;
        Node p = x;
        int height = 0;
        while (x != null) {
            height++;
            p = x;
            if (key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        uusi.height = height;
        uusi.parent = p;


        if (uusi.key < p.key) {
            p.left = uusi;
        } else {
            p.right = uusi;
        }
        return uusi;
    }

    public Node rightRotate(Node k1) {
        Node k2 = k1.left;
        k2.parent = k1.parent;
        k1.parent = k2;
        k1.left = k2.right;
        k2.right = k1;
        if (k1.left != null) {
            k1.left.parent = k1;
        }
        k1.height = Math.max(laskeKorkeus(k1.left), laskeKorkeus(k1.right)) + 1;
        k2.height = Math.max(laskeKorkeus(k2.left), laskeKorkeus(k2.right)) + 1;
        return k2;
    }

    public Node leftRotate(Node k1) {
        Node k2 = k1.right;
        k2.parent = k1.parent;
        k1.parent = k2;
        k1.right = k2.left;
        k2.left = k1;
        if (k1.right != null) {
            k1.right.parent = k1;
        }
        k1.height = Math.max(laskeKorkeus(k1.left), laskeKorkeus(k1.right)) + 1;
        k2.height = Math.max(laskeKorkeus(k2.left), laskeKorkeus(k2.right)) + 1;
        return k2;
    }

    public Node rightLeftRotate(Node k1) {
        Node k2 = k1.right;
        k1.right = rightRotate(k2);
        return leftRotate(k1);
    }

    public Node leftRightRotate(Node k1) {
        Node k2 = k1.left;
        k1.left = leftRotate(k2);
        return rightRotate(k1);
    }

    public Node min(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    public Node max(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
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
        AVLtree AVLtree = this;
        LinkedList list = new LinkedList(AVLtree.getRoot());
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
        int korkeus = laskeKorkeus(this.getRoot());
        int tamanHetkinenKorkeus = korkeus;
        int solmujenMaara = 1;
        int korkeudenLaskemisraja = 1;
        boolean tulostetaankoEkatValit = true;
        // Tehdään puusta "täydellinen" puu
        AVLtree avltree = teePuustaTaydellinen(this, korkeus);

        LinkedList list = new LinkedList(avltree.getRoot());
        Node nykyinen = list.getHeadNode();
        while (list.getSize() != 0) {
            if (tulostetaankoEkatValit) {
                tulostaValeja(getValienMaara(tamanHetkinenKorkeus));
            }
            if (!tulostetaankoEkatValit) {
                tulostaValeja(getValienMaara(tamanHetkinenKorkeus + 1));
            }
            tulostetaankoEkatValit = false;
            if (list.getHeadNode().onkoNull == false) {
                System.out.print(list.getHeadKey());
            }
            if (list.getHeadNode().onkoNull == true) {
                System.out.print(" ");
            }
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
            if (korkeudenLaskemisraja <= solmujenMaara) {
                System.out.println("");
                tulostetaankoEkatValit = true;
                korkeudenLaskemisraja = korkeudenLaskemisraja * 2 + 1;
                tamanHetkinenKorkeus--;
            }
            solmujenMaara++;
        }
    }

    private int getValienMaara(int korkeus) {
        if (korkeus == 1) {
            return 1;
        }
        if (korkeus == 2) {
            return 3;
        }
        int eka = 3;
        int toka = 1;
        int palautettava = 0;
        for (int i = 2; i < korkeus; i++) {
            palautettava = eka * 2 + toka;
            toka = eka;
            eka = palautettava;
        }
        return palautettava;
    }

    private void tulostaValeja(int maara) {
        for (int i = 0; i < maara; i++) {
            System.out.print(" ");
        }
    }

    private AVLtree teePuustaTaydellinen(AVLtree tree, int korkeus) {
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
            // Laitetaan feikkilapsi puuhun jos oikeaa lasta ei ole
            if (nykyinen.left == null) {
                nykyinen.left = new Node(nykyinen.key - 1, true);
                // Laitetaan jonoon myös feikkilapsi
                list.add(nykyinen.left);
                solmujenMaara++;
            }
            // Jos jonon päällä on oikea lapsi, laitetaan se jonoon
            if (nykyinen.right != null) {
                list.add(nykyinen.right);
                solmujenMaara++;
            }
            // Laitetaan feikkilapsi puuhun jos oikeaa lasta ei ole
            if (nykyinen.right == null) {
                nykyinen.right = new Node(nykyinen.key + 1, true);
                // Laitetaan jonoon myös feikkilapsi
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