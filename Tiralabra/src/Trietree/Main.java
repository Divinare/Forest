package Trietree;


public class Main {
    public static void main(String[] args) {
        Trietree trietree = new Trietree();
        trietree.add("sukka");
        trietree.add("b");
        trietree.add("s");
        
        System.out.println("Etsitään sana sukka");
        if (trietree.etsiSana("sukka")) {
            System.out.println("löytyi");
        }
        else {
            System.out.println("ei löytynyt sukkaa");
        }
        
        System.out.println("Etsitään sana sa");
        if (trietree.etsiSana("sa")) {
            System.out.println("löytyi");
        }
        else {
            System.out.println("ei löytynyt sa");
        }
            
        
        
    }
}
