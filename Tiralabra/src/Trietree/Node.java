package Trietree;

import DataStructures.ArrayList;

public class Node implements Comparable<Node> {

    private Character name;
    private ArrayList<Node> lapset;
    private int size;

    /**
     * Konstruktori alustaa solmun lapset arraylistin ja laittaa solmun kooksi
     * yhden.
     */
    public Node() {
        lapset = new ArrayList();
        size = 1;
    }

    /**
     * Etsii onko solmulla parametrinä annettua kirjainta lapsena. Palauttaa
     * true, jos kirjain lapsi löydettiin, muuten false.
     *
     * @param c kirjain, jota halutaan etsiä
     * @return true, jos lapsi löydettiin. Muuten false
     */
    public boolean containsChild(char c) {
        for (int i = 0; i < lapset.size(); i++) {
            if (lapset.get(i).getName() == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * Lisää solmuun parametrinä annetun sanan ensimmäisen kirjaimen ja lisää
     * kirjainsolmuun loput sanasta. Jos kirjainsolmu löytyy jo ennestään
     * puusta, kasvatetaan kirjainsolmun kokoa.
     *
     * @param sana sana, joka halutaan lisätä
     * @return solmu, joka lisättiin tai jos solmu oli jo puussa, palautetaan
     * se.
     */
    public Node add(String sana) {
        Node uusi = this.getChild(sana.charAt(0));
        String loput = sana.substring(1);
        if (uusi == null) {
            uusi = new Node();
            uusi.setName(sana.charAt(0));
            if (lapset.isEmpty()) {
                lapset.add(uusi);
            } else {
                int paikka = compareTo(uusi);
                lapset.add(paikka, uusi);
            }
            if (loput.length() > 0) {
                uusi.add(loput);
            }
        } else {
            if (loput.length() > 0) {
                uusi.add(loput);
                uusi.increaseSize();
                // Jos päästiin sanan loppuun, lisätään vain solmun kokoa
            } else {
                uusi.increaseSize();
            }
        }


        return uusi;
    }

    /**
     * Sanan poistaminen puusta. Kutsuu poisto-operaatiota eteenpäin lapsilleen,
     * jos sana jatkuu. Lopuksi poistaa kirjainsolmun puusta tai pienentää
     * kokoa, jos kirjaimia oli useampi kuin yksi.
     *
     * @param sana sana, joka halutaan poistaa
     */
    public void remove(String sana) {
        Node poistettava = getChild(sana.charAt(0));

        if (sana.length() > 1) {
            String loput = sana.substring(1);
            poistettava.remove(loput);
        }
        if (poistettava.size() > 1) {
            poistettava.decreaseSize();
        } else {
            lapset.remove(poistettava);
        }
    }

    /**
     * Hakee solmusta parametrinä annetun lapsisolmun.
     *
     * @param c kirjain, jonka nimistä solmua haetaan.
     * @return Palauttaa parametrinä annetun lapsisolmun tai nullin, jos lasta
     * ei löydy
     */
    public Node getChild(char c) {
        for (int i = 0; i < lapset.size(); i++) {
            if (lapset.get(i).getName() == c) {
                return lapset.get(i);
            }
        }
        Node tyhja = null;
        return tyhja; // :D
    }

    public char getName() {
        return name;
    }

    public Character getNamechar() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ArrayList<Node> getRoot() {
        return this.lapset;
    }

    public int size() {
        return size;
    }

    /**
     * Kasvattaa solmun kokoa
     */
    public void increaseSize() {
        size++;
    }

    /**
     * Vähentää solmun kokoa
     */
    public void decreaseSize() {
        size--;
    }
    /*
     * Palauttaa lapsien lukumäärän
     */

    public int getLapsetSize() {
        int koko = 0;
        for (int i = 0; i < lapset.size(); i++) {
            koko = koko + lapset.get(i).size();
        }
        return koko;

    }

    /**
     * Metodi kirjainsolmun oikean paikan etsimiseen lapset ArrayListissä.
     * Vertaa kirjainsolmua muihin lapsisolmuihin järjestyksessä, kunnes oikea
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
            if (lapset.get(paikka).name.compareTo(uusi.name) > 0) {
                break;
            }
            paikka++;
            // Jos ollaan listan päädyssä, niin paikka on listan lopussa.
            if (lapset.size() == paikka) {
                break;
            }
        }
        return paikka;
    }
}