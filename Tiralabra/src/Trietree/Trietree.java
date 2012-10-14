package Trietree;

import DataStructures.ArrayList;

public class Trietree implements Comparable<Node> {

    private ArrayList<Node> juuri;

    /**
     * Konstruktori, joka alustaa puun juuren.
     */
    public Trietree() {
        this.juuri = new ArrayList();
    }

    /**
     * Lisää triepuuhun sanan, joka annetaan parametrinä.
     *
     * @param sana sana, joka halutaan lisätä puuhun
     */
    public void add(String sana) {

        Node uusi = getChild(sana.charAt(0));
        String loput = sana.substring(1);
        if (uusi == null) {
            uusi = new Node();
            uusi.setName(sana.charAt(0));
            if (juuri.isEmpty()) {
                juuri.add(uusi);
            } else {
                int paikka = compareTo(uusi);
                juuri.add(paikka, uusi);
            }

            if (loput.length() > 0) {
                uusi.add(loput);
            }
        } else {
            if (loput.length() > 0) {
                uusi.add(loput);
                uusi.increaseSize();
            } // Jos päästiin sanan loppuun, lisätään vain solmun kokoa
            else {
                uusi.increaseSize();
            }
        }
    }

    /**
     * Poistaa puusta sanan, joka annetaan parametrinä.
     *
     * @param sana sana, joka halutaan poistaa puusta.
     * @return palauttaa true, jos poisto tehtiin, muuten false.
     */
    public boolean remove(String sana) {
        if (etsiSana(sana) == false) {
            return false;
        }
        Node poistettava = getChild(sana.charAt(0));

        if (sana.length() > 1) {
            String loput = sana.substring(1);
            poistettava.remove(loput);
        }
        if (poistettava.size() > 1) {
            poistettava.decreaseSize();
        } else {
            juuri.remove(poistettava);
        }
        return true;
    }

    /**
     * Etsii puusta parametrinä annetun sanan.
     */
    public boolean etsiSana(String sana) {
        Node current = null;
        // Haetaan juuresta sanan alkukirjaimen niminen solmu
        for (int i = 0; i < juuri.size(); i++) {
            if (juuri.get(i).getName() == sana.charAt(0)) {
                current = juuri.get(i);
            }
        }
        if (current == null) { // Jos sanan alkukirjainta ei edes löydy juuresta
            return false;
        }
        for (int i = 1; i < sana.length(); i++) {
            if (current.containsChild(sana.charAt(i))) {
                current = current.getChild(sana.charAt(i));
            } else {
                return false; // Jos kirjainta ei löytynyt
            }
        }
        // Katsotaan, jatkuuko sana eli esim jos puussa on sana sukka ja etsitään suk,
        // metodin täytyy palauttaa false ellei suk sanaa ole oikeasti puussa
        if (current.getLapsetSize() == current.size()) {
            return false;
        }
        return true;
    }

    private Node getChild(char c) {
        for (int i = 0; i < juuri.size(); i++) {
            if (juuri.get(i).getName() == c) {
                return juuri.get(i);
            }
        }
        Node tyhja = null;
        return tyhja;
    }

    /**
     * @return Palauttaa puun juurisolmun
     */
    public ArrayList<Node> getRoot() {
        return this.juuri;
    }

    /**
     * Metodi kirjainsolmun oikean paikan etsimiseen juuren ArrayListissä.
     * Vertaa kirjainsolmua muihin juuren solmuihin järjestyksessä, kunnes oikea
     * paikka löytyy
     *
     * @param uusi solmu, jonka paikka halutaan etsiä
     * @return palauttaa paikan, johon solmu voidaan laittaa, jotta
     * aakkosjärjestys säilyy
     */
    @Override
    public int compareTo(Node uusi) {
        int paikka = 0;
        while (true) {
            if (juuri.get(paikka).getNamechar().compareTo(uusi.getNamechar()) > 0) {
                break;
            }
            paikka++;
            // Jos ollaan listan päädyssä, niin paikka on listan lopussa.
            if (juuri.size() == paikka) {
                break;
            }
        }
        return paikka;
    }
}
