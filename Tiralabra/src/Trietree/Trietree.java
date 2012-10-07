package Trietree;

import java.util.ArrayList;

public class Trietree implements Comparable<Node> {

    private ArrayList<Node> juuri;

    public Trietree() {
        this.juuri = new ArrayList();
    }

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
            }
        }
    }

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

    public boolean etsiSana(String sana) {
        Node current = null;
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

    public Node getChild(char c) {
        for (int i = 0; i < juuri.size(); i++) {
            if (juuri.get(i).getName() == c) {
                return juuri.get(i);
            }
        }
        Node tyhja = null;
        return tyhja; // :D
    }

    public void tulostaSisalto(ArrayList<Node> lista) {
        if (lista.size() == 0) {
            System.out.println("");
        }


        for (int i = 0; i < lista.size(); i++) {
//            for (int j = 0; j < lista.get(i).size(); j++) {
            System.out.print(lista.get(i).getName());
            tulostaSisalto(lista.get(i).getRoot());
//            }
        }
    }

    public ArrayList<Node> getRoot() {
        return this.juuri;
    }

    @Override
    public int compareTo(Node uusi) {
        int paikka = 0;
        while (true) {
            if (juuri.get(paikka).getNamechar().compareTo(uusi.getNamechar()) > 0) {
                break;
            }
            paikka++;
        }
        return paikka;
    }
}
