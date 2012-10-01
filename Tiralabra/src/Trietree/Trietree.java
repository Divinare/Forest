package Trietree;

import java.util.ArrayList;

public class Trietree {

    private ArrayList<Node> juuri;

    public Trietree() {
        this.juuri = new ArrayList();
    }

    public void add(String sana) {

        Node uusi = this.getChild(sana.charAt(0));
        String loput = sana.substring(1);
        if (uusi == null) {
            uusi = new Node();
            uusi.setName(sana.charAt(0));
            juuri.add(uusi);
            if (loput.length() > 0) {
                uusi.add(loput);
            }
        } else {
            if (loput.length() > 0) {
                uusi.add(loput);
            }
        }
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

    public void tulostaSisalto(ArrayList<Node> lista, int index) {
        if (lista.size() <= index) {
            return;
        }
        if (lista.get(index) == null) {

            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i).getName());

            tulostaSisalto(lista.get(i).getRoot(), index);
        }
    }
    
    public void tulosta(ArrayList<Node> lista) {
        for (int i = 0; i < lista.size(); i++) {
            
            System.out.print(lista.get(i).getName());
            tulosta(lista.get(i).getRoot());
            System.out.println("");
            
        }
    }

    public ArrayList<Node> getRoot() {
        return this.juuri;
    }
}
