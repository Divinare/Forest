package DataStructures;


public class Main {
    
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        list.add(3, 2);
        System.out.println(list.get(2));
    }
}
