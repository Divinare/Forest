package Trietree;

import java.util.ArrayList;

public class Node implements Comparable<Node> {

    private Character name;
    private ArrayList<Node> lapset;
    private int size;

    public Node() {
        lapset = new ArrayList();
        size = 1;
    }

    public boolean containsChild(char c) {
        for (int i = 0; i < lapset.size(); i++) {
            if (lapset.get(i).getName() == c) {
                return true;
            }
        }
        return false;
    }

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
            }
        }

        return uusi;
    }

    public boolean remove(String sana) {
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
        return true;
    }

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

    public void increaseSize() {
        size++;
    }

    public void decreaseSize() {
        size--;
    }

    public int getLapsetSize() {
        return lapset.size();
    }

    @Override
    public int compareTo(Node uusi) {
        int paikka = 0;
        while (true) {
            if (lapset.get(paikka).name.compareTo(uusi.name) > 0) {
                break;
            }
            paikka++;
        }
        return paikka;
    }
}