package AVLtree;

public class Main {

    public static void main(String[] args) {
        // AVL-puun testausta:
        AVLtree avltree = new AVLtree(5);
        avltree.AVLinsert(8);
        avltree.AVLinsert(7);
        avltree.AVLinsert(10);
        avltree.AVLinsert(2);
        avltree.AVLinsert(4);
        avltree.AVLinsert(1);
        avltree.AVLinsert(3);
        System.out.println("in-order läpikäynti:");
        avltree.printInOrder(avltree.getRoot());
        System.out.println("pre-order läpikäynti:");
        avltree.printPreOrder(avltree.getRoot());
        System.out.println("level-order läpikäynti:");
        avltree.printLevelOrder();
        System.out.println("max on " + avltree.max(avltree.getRoot()).key);
        System.out.println("min on " + avltree.min(avltree.getRoot()).key);

    }
}
