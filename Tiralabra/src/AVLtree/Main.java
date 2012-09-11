package AVLtree;


public class Main {
    public static void main(String[] args) {
        // AVL-puun testausta:
        AVLtree avltree = new AVLtree(5);
        avltree.insert(8);
        avltree.insert(7);
        avltree.insert(10);
        avltree.insert(2);
        avltree.insert(4);
        avltree.insert(1);
        avltree.insert(3);
        System.out.println("in-order läpikäynti:");
        avltree.printInOrder(avltree.getRoot());
        System.out.println("pre-order läpikäynti:");
        avltree.printPreOrder(avltree.getRoot());
        System.out.println("max on " + avltree.max(avltree.getRoot()));
        System.out.println("min on " + avltree.min(avltree.getRoot()));
        
    }
}
