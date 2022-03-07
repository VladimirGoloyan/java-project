import java.util.Iterator;

public class ArrayList<T> implements ListADT<T> {

    private int size;
    private Object[] arr;

    public ArrayList() {
        size = 0;
        arr = new Object[10];
    }

    public ArrayList(int cap) {
        if (cap > 10)
            arr = new Object[cap];
        else
            arr = new Object[10];
        size = 0;
    }

    public void ensureCapacity() {
        if (size == arr.length) {
            System.out.println("Storage out, resizing");
            resize();
        }
    }

    public void resize() {
        Object[] temp = new Object[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        arr = temp;
    }

    public int size() {
        return size;
    }

    public void addLast(T el) {
        ensureCapacity();
        arr[size] = el;
        size++;
    }

    public void addFirst(T el) {
        ensureCapacity();

        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = el;
        size++;
    }

    public boolean removeFirst() {
        if (size == 0) {
            return false;
        }

        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[size - 1] = null;
        size--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if (size == 0) {
            return false;
        }

        for (int i = size - 1; i > 0; i--) {
            arr[i - 1] = arr[i];
        }

        arr[size - 1] = null;
        size--;
        return true;
    }

    @Override
    public T first() {
        // TODO Auto-generated method stub
        return (T) arr[0];
    }

    @Override
    public T last() {
        // TODO Auto-generated method stub
        return (T) arr[size - 1];
    }

    @Override
    public boolean replace(T e, T r) {
        if (size == 0) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] == e) {
                arr[i] = r;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

    @Override
    public void empty() {
        // TODO Auto-generated method stub
        arr = new Object[10];

    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        System.out.println("Starting arrayList print");
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " is at " + i + "th index of array");
        }
        System.out.println("ArrayList print ended");
    }

    public boolean swap(T v1, T v2) {
        int i1 = findIndex(v1);
        int i2 = findIndex(v2);

        if (i1 == -1 || i2 == -1) {
            return false;
        }

        if (arr[i1] == arr[i2]) {
            return true;
        }

        T temp = (T) arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;

        return true;
    }

    public int findIndex(T value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public T getElement(int index) {
        if (index > -1 && index < size)
            return (T) arr[index];
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new ForwardIterator();
    }

    public Iterator<T> OddIterator() {
        // TODO Auto-generated method stub
        if (size < 2) {
            return null;
        }
        return new MyOddIterator();
    }

    private class ForwardIterator<T> implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return index < size;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            return (T) arr[index++];
        }

        public void remove() {
            //remove index-1;
        }

    }

    private class MyOddIterator<T> implements Iterator<T> {
        private int index = 1;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return index + 2 < size;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            return (T) arr[index += 2];
        }
    }

}
