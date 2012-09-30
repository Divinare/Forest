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
        }
        return false;
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
