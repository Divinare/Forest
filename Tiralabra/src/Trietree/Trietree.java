package Trietree;

import java.util.ArrayList;

public class Trietree {

    private ArrayList<ArrayList> juuri;

    public Trietree() {
        this.juuri = new ArrayList();
    }

    public void add(String sana) {
        int index = 0;
        ArrayList list = juuri;
        while (index == sana.length()) {
            char c = sana.charAt(index);
            if (list.contains(c)) {
            }
        }
    }
}
