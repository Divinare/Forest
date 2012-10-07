package DataStructures;

public class ArrayList {

    private int size;
    private Object[] taulu;

    public ArrayList() {
        this.size = 0;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (taulu[i] == null) {
                    int numMoved = size - i - 1;
                    if (numMoved > 0) {
                        System.arraycopy(taulu, i + 1, taulu, i, numMoved);
                        size--;
                    }
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (taulu[i] == o) {
                    int numMoved = size - i - 1;
                    if (numMoved > 0) {
                        System.arraycopy(taulu, i + 1, taulu, i, numMoved);
                        size--;
                    }
                }
            }

        }
        return false;
    }

    public void add(Object o) {
        if (size == 0) {
            taulu = new Object[1];
            taulu[0] = o;
            size++;
        } else {
            if (size == taulu.length) {
                Object[] uusiTaulu = new Object[taulu.length * 2];
                System.arraycopy(taulu, 0, uusiTaulu, 0, taulu.length);
                taulu = uusiTaulu;
            }
            taulu[size] = o;
            size++;
        }
    }

    public void add(Object o, int index) {
        if (size == 0 && index == 0) {
            taulu = new Object[1];
            taulu[0] = o;
            size++;
        } else {
            if (size == taulu.length) {
                Object[] uusiTaulu = new Object[taulu.length * 2];
                System.arraycopy(taulu, 0, uusiTaulu, 0, taulu.length);
                taulu = uusiTaulu;
            }
            Object[] loppuosa = new Object[taulu.length-index];
            System.arraycopy(loppuosa, index, taulu, 0, taulu.length-index);
            taulu[index] = o;
            System.arraycopy(taulu, index, loppuosa, 0, loppuosa.length);
            size++;
    }
}
public boolean isEmpty() {
        for (int i = 0; i < taulu.length; i++) {
            if (taulu[i] != null) {
                return false;
            }
        }
        return true;
    }
    
    public Object get(int i) {
        return taulu[i];
    }
    

//    public int indexOf(Object o) {
//        if (o == null) {
//            for (int i = 0; i < size; i++) {
//                if (taulu[i] == null) {
//                    return i;
//                }
//            }
//        } else {
//            for (int i = 0; i < size; i++) {
//                if (o.equals(taulu[i])) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }

    public int size() {
        return size;
    }
}
