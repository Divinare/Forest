package DataStructures;

public class ArrayList {

    private int size;
    private Object[] taulu;

    public ArrayList() {
        this.size = 10;
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
        for (int i = 0; i < size; i++) {
            if (taulu[i] == null) {
                taulu[i] = o;
                return;
            }
        }
        Object[] uusiTaulu = new Object[size*2];
        System.arraycopy(taulu, 0, uusiTaulu, size-1, size);
        taulu = uusiTaulu;
        uusiTaulu[size] = o;
        size = size*2;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (taulu[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(taulu[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }
}
