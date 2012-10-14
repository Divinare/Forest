package Trietree;

public class Main {

    public static void main(String[] args) {
        //Trietreen testausta:
        Trietree trietree = new Trietree();
        trietree.add("sukka");
        trietree.add("saapas");
        trietree.add("aita");
        trietree.add("aasi");
        trietree.add("b");
        trietree.add("s");
        trietree.add("susi");

        System.out.println("Trien testausta:" + "\n");
        System.out.println("Etsitään sana sukka");
        if (trietree.etsiSana("sukka")) {
            System.out.println("löytyi");
        } else {
            System.out.println("ei löytynyt sukkaa");
        }

        System.out.println("Etsitään sana saaps");
        if (trietree.etsiSana("saaps")) {
            System.out.println("löytyi" + "\n");
        } else {
            System.out.println("ei löytynyt saaps" + "\n");
        }
        System.out.println("Tulostetaan juuren koko");
        System.out.println(trietree.getRoot().get(0).size());
        System.out.println("Poistetaan aasi");
        trietree.remove("aasi");
        System.out.println("Tulostetaan juuren koko");
        System.out.println(trietree.getRoot().get(0).size());

        System.out.println("Koitetaan poistaa sanat ait ja sukkaaa (joita ei siis ole)");
        trietree.remove("ait");
        trietree.remove("sukkaaa");
        System.out.println("Tulostetaan juuren koko");
        System.out.println(trietree.getRoot().get(0).size() + "\n");

        System.out.println("Puun ensimmäisen noden nimi on: " + trietree.getRoot().get(0).getName() + "\n");

        System.out.println("Löytyykö sanaa s?");
        if (trietree.etsiSana("s")) {
            System.out.println("löytyi" + "\n");
        } else {
            System.out.println("ei löytynyt" + "\n");
        }
        System.out.println(trietree.getRoot().get(2).size());

        trietree.remove("s");
        System.out.println("Poistettiin s, löytyykö nyt?");
        if (trietree.etsiSana("s")) {
            System.out.println("löytyi" + "\n");
        } else {
            System.out.println("ei löytynyt" + "\n");
        }

        System.out.println("Poistuuko sana kokonaan puusta? Poistetaan saapas,"
                + " etsitään saapa");
        trietree.remove("saapas");
        if (trietree.etsiSana("saapa")) {
            System.out.println("löytyi" + "\n");
        } else {
            System.out.println("ei löytynyt" + "\n");
        }
        
    }
}
