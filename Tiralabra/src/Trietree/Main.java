package Trietree;

public class Main {

    public static void main(String[] args) {
        Trietree trietree = new Trietree();
        trietree.add("sukka");
        trietree.add("saapas");
        trietree.add("aita");
        trietree.add("aasi");
        trietree.add("b");
        trietree.add("s");

//        trietree.add("aasi");
//        trietree.add("aita");
//        trietree.add("b");
//        trietree.add("s");
//        trietree.add("saapas");
//        trietree.add("sukka");
        
//        trietree.jarjesta;

        System.out.println("Etsitään sana sukka");
        if (trietree.etsiSana("sukka")) {
            System.out.println("löytyi");
        } else {
            System.out.println("ei löytynyt sukkaa");
        }

        System.out.println("Etsitään sana saaps");
        if (trietree.etsiSana("saaps")) {
            System.out.println("löytyi");
        } else {
            System.out.println("ei löytynyt saaps");
        }
        System.out.println("##########################");
        System.out.println("tulostetaan");
        trietree.tulostaSisalto(trietree.getRoot());

        System.out.println("#########################");
        System.out.println(trietree.getRoot().get(0).size());

        System.out.println("#########################");
        trietree.remove("aasi");
        trietree.remove("ait");
        trietree.remove("sukkaaa");
        trietree.tulostaSisalto(trietree.getRoot());
        System.out.println(trietree.getRoot().get(0).size());
        System.out.println("#########################");
        
//        System.out.println(trietree.getRoot().get(0).getName());

//        trietree.tulostaSisalto(trietree.getRoot());
//        if (trietree.etsiSana("s")) {
//            System.out.println("zzz");
//        } else {
//            System.out.println("jee");
//        }
        
    }
}
