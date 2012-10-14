package AVLtree;
import DataStructures.Node;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        // AVL-puun testausta:
        AVLtree avltree = new AVLtree(5);
        avltree.AVLinsert(8);
        avltree.AVLinsert(7);
        avltree.AVLinsert(10);
        System.out.println("tulostetaan puu:");
        avltree.printTree();
        avltree.AVLinsert(2);
        avltree.AVLinsert(4);
        System.out.println("tulostetaan puu:");
        avltree.printTree();
        avltree.AVLinsert(1);
        avltree.AVLinsert(6);
        avltree.AVLinsert(11);
        avltree.AVLinsert(9);
        System.out.println("in-order läpikäynti:");
        avltree.printInOrder(avltree.getRoot());
        System.out.println("pre-order läpikäynti:");
        avltree.printPreOrder(avltree.getRoot());
        System.out.println("level-order läpikäynti:");
        avltree.printLevelOrder();
        System.out.println("max on " + avltree.max(avltree.getRoot()).key);
        System.out.println("min on " + avltree.min(avltree.getRoot()).key);
        System.out.println("tulostetaan puu:");
        avltree.printTree();
        System.out.println("poistetaan 2:");
        avltree.AVLdelete(avltree.search(avltree.getRoot(), 2));
        avltree.printTree();
        System.out.println("poistetaan 1:");
        avltree.AVLdelete(avltree.search(avltree.getRoot(), 1));
        avltree.printTree();
        System.out.println("poistetaan 7:");
        avltree.AVLdelete(avltree.search(avltree.getRoot(), 7));
        avltree.printTree();
        System.out.println("poistetaan 5:");
        avltree.AVLdelete(avltree.search(avltree.getRoot(), 5));
        avltree.printTree();
        System.out.println("poistetaan 8");
        avltree.AVLdelete(avltree.search(avltree.getRoot(), 8));
        avltree.printTree();
        System.out.println("poistetaan 10");
        avltree.AVLdelete(avltree.search(avltree.getRoot(), 10));
        avltree.printTree();
        System.out.println("poistetaan 7, jota ei ole puussa");
        avltree.AVLdelete(avltree.search(avltree.getRoot(), 7));
        avltree.printTree();     
    }
}
