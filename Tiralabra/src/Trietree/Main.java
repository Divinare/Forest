package Trietree;

public class Main {

    public static void main(String[] args) {
        Trietree trietree = new Trietree();
//        trietree.add("sukka");
//        trietree.add("saapas");
//        trietree.add("aita");
//        trietree.add("aasi");
//        trietree.add("b");
//        trietree.add("s");

        trietree.add("aasi");
        trietree.add("aita");
        trietree.add("b");
        trietree.add("s");
        trietree.add("saapas");
        trietree.add("sukka");
//        trietree.jarjesta;

        System.out.println("Etsitään sana sukka");
        if (trietree.etsiSana("sukka")) {
            System.out.println("löytyi");
        } else {
            System.out.println("ei löytynyt sukkaa");
        }

        System.out.println("Etsitään sana sa");
        if (trietree.etsiSana("sa")) {
            System.out.println("löytyi");
        } else {
            System.out.println("ei löytynyt sa");
        }
        System.out.println("##########################");
        System.out.println("tulostetaan");
        trietree.tulostaSisalto(trietree.getRoot(), 0);
        
//        trietree.tulosta(trietree.getRoot());
        
        

    }
}
