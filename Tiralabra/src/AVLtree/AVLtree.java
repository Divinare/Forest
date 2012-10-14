package AVLtree;

import DataStructures.Node;
import DataStructures.LinkedList;

public class AVLtree implements Cloneable {

    private Node root;

    /**
     * Konstruktori, jolle annetaan juuren avain
     *
     * @param key
     */
    public AVLtree(int key) {
        this.root = new Node(key, false);
    }

    /**
     * Konstruktori, jolle annetaan juuri solmuna
     *
     * @param root
     */
    public AVLtree(Node root) {
        this.root = root;
    }

    /**
     * AVLpuun lisäys, joka tarvittaessa korjaa epätasapainon
     *
     * @param key
     */
    public void AVLinsert(int key) {
        Node uusi = insert(key);
        if (uusi == null) {
            return;
        }
        Node p = uusi.parent;
        // Tarkistetaan menikö puu epätasapainoon, jos meni niin suoritetaan tarvittavat kierrot
        while (p != null) {
            Node alipuu;
            int lChildHeight = -1, rChildHeight = -1;
            if (p.left != null) {
                lChildHeight = p.left.height;
            }
            if (p.right != null) {
                rChildHeight = p.right.height;
            }
            // Aiheuttaako vanhemman vasen lapsi epätasapainon
            if (lChildHeight == rChildHeight + 2) {
                balanceLeftChild(p);
                return;
            }
            // Aiheuttaako vanhemman oikea lapsi epätasapainon
            if (rChildHeight == lChildHeight + 2) {
                balanceRightChild(p);
                return;
            }
            lChildHeight = -1;
            rChildHeight = -1;
            if (p.left != null) {
                lChildHeight = p.left.height;
            }
            if (p.right != null) {
                rChildHeight = p.right.height;
            }
            p.height = kumpiKorkeampi(lChildHeight, rChildHeight) + 1;
            p = p.parent; // jatketaan kohti juurta
        }
    }

    private Node insert(int key) {
        Node uusi = new Node(key, false);
        uusi.height = 0;
        // Jos puussa ei ole mitään, laitetaan uusi solmu juureksi
        if (root == null) {
            root = uusi;
            return uusi;
        }

        Node current = root;
        Node parent = current;
        while (current != null) {
            parent = current;
            if (current.key == key) {
                return null;
            }
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        uusi.parent = parent;

        // Asetetaan vanhemman lapseksi uusi solmu
        if (uusi.key < parent.key) {
            parent.left = uusi;
            if (parent.right == null) {
                parent.height = 1;
            }
        } else {
            parent.right = uusi;
            if (parent.left == null) {
                parent.height = 1;
            }
        }
        return uusi;
    }

    /**
     * AVLpuusta solmun poistava metodi, joka tarvittaessa korjaa syntyneen
     * epätasapainon
     *
     * @param poistettava
     */
    public void AVLdelete(Node poistettava) {
        // Varmistetaan, ettei tyhjää koiteta poistaa
        if (poistettava != null) {
            Node poistettu = delete(poistettava);
            // Jos poistettiin jotain
            if (poistettu != null) {
                Node alipuu;
                Node p = poistettu.parent;
                while (p != null) {
                    Node parent = p.parent;
                    int lChildHeight = -1;
                    int rChildHeight = -1;
                    if (p.left != null) {
                        lChildHeight = p.left.height;
                    }
                    if (p.right != null) {
                        rChildHeight = p.right.height;
                    }
                    if (lChildHeight == rChildHeight + 2) {
                        balanceLeftChild(p);
                        return;

                    }
                    if (rChildHeight == lChildHeight + 2) {
                        balanceRightChild(p);
                        return;
                    }
                    p.height = kumpiKorkeampi(lChildHeight, rChildHeight + 1);
                    // Jatketaan kohti juurta
                    p = parent;

                }
            }
        }
    }

    private Node delete(Node poistettava) {
        // Onko poistettava puussa
        if (search(this.getRoot(), poistettava.key) != null) {

            // Poistettavalla ei ole lapsia:
            if (poistettava.left == null && poistettava.right == null) {
                Node vanhempi = poistettava.parent;
                if (vanhempi == null) { // poistettava on puun ainoa solmu
                    this.root = null;
                    return poistettava;
                }
                if (poistettava == vanhempi.left) {
                    vanhempi.left = null;
                } else {
                    vanhempi.right = null;
                }
                return poistettava;
            }
            // Poistettavalla on yksi lapsi
            if (poistettava.left == null || poistettava.right == null) {
                Node lapsi;
                if (poistettava.left != null) {
                    lapsi = poistettava.left;
                } else {
                    lapsi = poistettava.right;
                }
                Node vanhempi = poistettava.parent;
                lapsi.parent = vanhempi;
                if (vanhempi == null) { // poistettava on juuri
                    this.root = lapsi;
                    return poistettava;
                }
                if (poistettava == vanhempi.left) {
                    vanhempi.left = lapsi;
                } else {
                    vanhempi.right = lapsi;
                }
                return poistettava;
            }
            // Poistettavalla on kaksi lasta
            Node seuraaja = min(poistettava.right);
            poistettava.key = seuraaja.key;
            Node lapsi = seuraaja.right;
            Node vanhempi = seuraaja.parent;
            if (vanhempi.left == seuraaja) {
                vanhempi.left = lapsi;
            } else {
                vanhempi.right = lapsi;
            }
            if (lapsi != null) {
                lapsi.parent = vanhempi;
            }
            return seuraaja;
        }
        return null;
    }

    /**
     * Asettaa p:n (eli solmun, jonka epätasapaino korjattiin) vanhemman
     * vasemmaksi tai oikeaksi lapseksi alipuun, joka saatiin kun puussa
     * suoritettiin kiertoja
     *
     * @param parent p:n vanhempi
     * @param alipuu kierroista saatu alipuu
     * @param p solmu, jonka epätasapaino korjattiin
     */
    private void fixParent(Node parent, Node alipuu, Node p) {
        // p on poistetun vanhempi
        if (parent == null) {
            this.root = alipuu;
        } else if (parent.left == p) {
            parent.left = alipuu;
        } else {
            parent.right = alipuu;
        }
        if (parent != null) {
            parent.height = kumpiKorkeampi(laskeKorkeus(parent.left), laskeKorkeus(parent.right)) + 1;
        }
    }

    private Node rightRotate(Node x) {
        Node xLeft = x.left;
        xLeft.parent = x.parent;
        x.parent = xLeft;
        x.left = xLeft.right;
        xLeft.right = x;
        if (x.left != null) {
            x.left.parent = x;
        }
        x.height = kumpiKorkeampi(laskeKorkeus(x.left), laskeKorkeus(x.right)) + 1;
        xLeft.height = kumpiKorkeampi(laskeKorkeus(xLeft.left), laskeKorkeus(xLeft.right)) + 1;
        return xLeft;
    }

    private Node leftRotate(Node x) {
        Node xRight = x.right;
        xRight.parent = x.parent;
        x.parent = xRight;
        x.right = xRight.left;
        xRight.left = x;
        if (x.right != null) {
            x.right.parent = x;
        }
        x.height = kumpiKorkeampi(laskeKorkeus(x.left), laskeKorkeus(x.right)) + 1;
        xRight.height = kumpiKorkeampi(laskeKorkeus(xRight.left), laskeKorkeus(xRight.right)) + 1;
        return xRight;
    }

    private Node rightLeftRotate(Node x) {
        Node xRight = x.right;
        x.right = rightRotate(xRight);
        return leftRotate(x);
    }

    private Node leftRightRotate(Node x) {
        Node xLeft = x.left;
        x.left = leftRotate(xLeft);
        return rightRotate(x);
    }
    /**
     * Suorittaa tarvittavat kierrot solmun p vasemmalle lapselle, joka
     * on epätasapainossa ja kutsuu metodia fixParent
     * @param p solmu, jonka vasen lapsi on epätasapainossa
     */
    private void balanceLeftChild(Node p) {
        Node alipuu;
        Node parent = p.parent;
        // onko syy vasemman lapsen vasemmassa vai oikeassa alipuussa?
        if (laskeKorkeus(p.left.left) > laskeKorkeus(p.left.right)) {
            alipuu = rightRotate(p);
        } else {
            alipuu = leftRightRotate(p);
        }
        // Asetetaan p:n vanhemman lapseksi alipuu
        fixParent(parent, alipuu, p);
    }
    /**
     * Suorittaa tarvittavat kierrot solmun p oikealle lapselle, joka
     * on epätasapainossa ja kutsuu metodia fixParent
     * @param p solmu, jonka oikea lapsi on epätasapainossa
     */
    private void balanceRightChild(Node p) {
        Node alipuu;
        Node parent = p.parent;
        // onko syy oikean lapsen oikeassa vai vasemmassa alipuussa?
        if (laskeKorkeus(p.right.right) > laskeKorkeus(p.right.left)) {
            alipuu = leftRotate(p);
        } else {
            alipuu = rightLeftRotate(p);
        }
        // Asetetaan p:n vanhemman lapseksi alipuu
        fixParent(parent, alipuu, p);
    }

    /**
     * Palauttaa minimin
     *
     * @param x Node, josta kohtaa puuta lähdetään minimiä etsimään
     * @return Node minimi
     */
    public Node min(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    /**
     * Palauttaa maximin
     *
     * @param x Node, josta kohtaa puuta lähdetään maximia etsimään
     * @return Node maximi
     */
    public Node max(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    /**
     * Etsii puusta haettavan arvon
     *
     * @param x Node, josta kohtaa puuta lähdetään arvoa etsimään
     * @param key arvo, joka halutaan etsiä
     * @return Node, jota etsittiin tai null jos ei löytynyt
     */
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

    /**
     * Laskee puun korkeuden
     *
     * @param x Node, josta kohtaa puun korkeutta lähdetään laskemaan
     * @return puun korkeus
     */
    public int laskeKorkeus(Node x) {
        if (x == null) {
            return -1;
        }
        int k1 = laskeKorkeus(x.left);
        int k2 = laskeKorkeus(x.right);
        return Math.max(k1, k2) + 1;
    }

    /**
     * Tulostaa puun sisäjärjestyksessä
     *
     * @param x
     */
    public void printInOrder(Node x) {
        if (x != null) {
            printInOrder(x.left);
            System.out.println(x.key);
            printInOrder(x.right);
        }
    }

    /**
     * Tulostaa puun esijärjestyksessä
     *
     * @param x
     */
    public void printPreOrder(Node x) {
        if (x != null) {
            System.out.println(x.key);
            printPreOrder(x.left);
            printPreOrder(x.right);

        }
    }

    /**
     * Tulostaa puun tasojärjestyksessä
     *
     * @param x
     */
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

    /**
     * Tulostaa puun graafiseen tyyliin
     *
     * @throws CloneNotSupportedException
     */
    public void printTree() throws CloneNotSupportedException {
        int korkeus = laskeKorkeus(this.getRoot());
        int tamanHetkinenKorkeus = korkeus;
        int solmujenMaara = 1;
        int korkeudenLaskemisraja = 1;
        boolean tulostetaankoEkatValit = true;
        // Tehdään puusta "täydellinen" puu

        AVLtree copyTree = (AVLtree) this.clone();
        AVLtree avltree = teePuustaTaydellinen(copyTree, korkeus);

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

    /**
     * Palauttaa puun juuren
     *
     * @return
     */
    public Node getRoot() {
        return root;
    }

    private int kumpiKorkeampi(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    /**
     *
     * @return @throws CloneNotSupportedException
     */
    protected Object clone()
            throws CloneNotSupportedException {
        Node clone = (Node) this.getRoot().clone();
        AVLtree cloneTree = new AVLtree(clone);

        return cloneTree;

    }
}