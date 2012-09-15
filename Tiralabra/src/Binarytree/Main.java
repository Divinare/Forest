package Binarytree;


public class Main {
    
    public static void main(String[] args) {
        // Binääripuun testausta:
        Binarytree binarytree = new Binarytree(5);
//        binarytree.lol();
        binarytree.insert(8);
        binarytree.insert(7);
//        binarytree.insert(10);
        binarytree.insert(2);
        binarytree.insert(4);
        binarytree.insert(1);
        binarytree.insert(3);
        System.out.println("in-order läpikäynti:");
        binarytree.printInOrder(binarytree.getRoot());
        System.out.println("pre-order läpikäynti:");
        binarytree.printPreOrder(binarytree.getRoot());
        System.out.println("level-order läpikäynti:");
        binarytree.printLevelOrder();
        System.out.println("max on " + binarytree.max(binarytree.getRoot()));
        System.out.println("min on " + binarytree.min(binarytree.getRoot()));
        System.out.println("etsitään avain 7 : " + binarytree.search(binarytree.getRoot(), 7).key);
        System.out.println("Puu tulostettuna: ");
        binarytree.printTree();
        
    }
}