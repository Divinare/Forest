package Nopeustestit;

import AVLtree.AVLtree;
import Binarytree.Binarytree;
import Trietree.Trietree;
import DataStructures.Node;

public class Nopeustestit {

    public static void main(String[] args) {
        AVLtree avltree = new AVLtree(5);
        Binarytree binarytree = new Binarytree(5);
        Trietree trietree = new Trietree();
        Trietree trietree2 = new Trietree();


        long aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            avltree.AVLinsert((int) (Math.random() * 1000));
        }
        long aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa AVL puun 10 000 000 numeron lisäykseen kului: "
                + (aikaLoppu - aikaAlku) + "ms");

        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            avltree.search(avltree.getRoot(), (int) (Math.random() * 1000));
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa AVL puusta 10 000 000 numeron etsimiseen kului: "
                + (aikaLoppu - aikaAlku) + "ms");

        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            avltree.min(avltree.getRoot());
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa AVL puusta  10 000 000 min numeron hakemiseen kului: "
                + (aikaLoppu - aikaAlku) + "ms");

        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            avltree.AVLdelete(avltree.search(avltree.getRoot(), (int) (Math.random() * 1000)));
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa AVL puusta 10 000 000 numeron poistamiseen kului: "
                + (aikaLoppu - aikaAlku) + "ms");


        System.out.println("");


        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            binarytree.insert((int) (Math.random() * 1000));
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa binääripuun 10 000 000 numeron lisäykseen kului: "
                + (aikaLoppu - aikaAlku) + "ms");

        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            binarytree.search(binarytree.getRoot(), (int) (Math.random() * 1000));
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa binääripuusta 10 000 000 numeron etsimiseen kului: "
                + (aikaLoppu - aikaAlku) + "ms");

        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            binarytree.min(binarytree.getRoot());
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa binääripuusta 10 000 000 min numeron hakemiseen kului: "
                + (aikaLoppu - aikaAlku) + "ms");

        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            binarytree.delete(binarytree.search(binarytree.getRoot(), (int) (Math.random() * 1000)));
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa binääripuusta 10 000 000 numeron poistamiseen kului: "
                + (aikaLoppu - aikaAlku) + "ms");


        System.out.println("");


        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            trietree.add("" + (int) (Math.random() * 1000));
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa triepuun 10 000 000 numeron lisäykseen 3 numeron "
                + "mittaisilla alkioilla kului: " + (aikaLoppu - aikaAlku) + "ms");

        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            trietree2.add("" + (int) (Math.random() * 1000000));
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa triepuun 10 000 000 numeron lisäykseen 6 numeron "
                + "mittaisilla alkioilla kului: " + (aikaLoppu - aikaAlku) + "ms");

        System.out.println("");

        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            trietree.etsiSana("" + (int) (Math.random() * 1000));
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa triepuun 10 000 000 numeron etsimiseen 3 numeron "
                + "mittaisilla alkioilla kului: " + (aikaLoppu - aikaAlku) + "ms");

        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            trietree2.etsiSana("" + (int) (Math.random() * 1000000));
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa triepuun 10 000 000 numeron etsimiseen 6 numeron "
                + "mittaisilla alkioilla kului: " + (aikaLoppu - aikaAlku) + "ms");

        System.out.println("");

        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            trietree.remove("" + (int) (Math.random() * 1000));
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa triepuun 10 000 000 numeron poistamiseen 3 numeron "
                + "mittaisilla alkioilla kului: " + (aikaLoppu - aikaAlku) + "ms");

        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            trietree2.remove("" + (int) (Math.random() * 1000000));
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa triepuun 10 000 000 numeron poistamiseen 6 numeron "
                + "mittaisilla alkioilla kului: " + (aikaLoppu - aikaAlku) + "ms");

        System.out.println("");

        Trietree trietree3 = new Trietree();
        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            trietree3.add("moi");
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa kului 3 merkkisen saman sanan lisäykseen: "
                + (aikaLoppu - aikaAlku) + "ms");


        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            trietree3.etsiSana("moi");
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa kului 3 merkkisen saman sanan etsimiseen: "
                + (aikaLoppu - aikaAlku) + "ms");


        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            trietree3.remove("moi");
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa kului 3 merkkisen saman sanan poistoon: "
                + (aikaLoppu - aikaAlku) + "ms");

        System.out.println("");
        
        Trietree trietree4 = new Trietree();
        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            trietree4.add("sanamoi");
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa kului 7 merkkisen saman sanan lisäykseen: "
                + (aikaLoppu - aikaAlku) + "ms");


        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            trietree4.etsiSana("sanamoi");
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa kului 7 merkkisen saman sanan hakuun: "
                + (aikaLoppu - aikaAlku) + "ms");


        aikaAlku = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            trietree4.remove("sanamoi");
        }
        aikaLoppu = System.currentTimeMillis();
        System.out.println("Aikaa kului 7 merkkisen saman sanan poistoon: "
                + (aikaLoppu - aikaAlku) + "ms");
    }
}
