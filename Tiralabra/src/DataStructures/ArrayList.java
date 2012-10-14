package DataStructures;

public class ArrayList<E> {

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

    public void add(int index, Object o) {
        if (index > size) {
            return;
        }
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
            Object[] loppuosa = new Object[size - index];
            for (int i = 0; i < loppuosa.length; i++) {
                loppuosa[i] = taulu[index + i];
            }

            taulu[index] = o;
            for (int i = 0; i < loppuosa.length; i++) {
                taulu[index + i +1] = loppuosa[i];
            }
            size++;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        for (int i = 0; i < taulu.length; i++) {
            if (taulu[i] != null) {
                return false;
            }
        }
        return true;
    }

    public E get(int i) {
        rangeCheck(i);
        return (E)taulu[i];
    }
    
    private void rangeCheck(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    public int size() {
        return size;
    }
}
