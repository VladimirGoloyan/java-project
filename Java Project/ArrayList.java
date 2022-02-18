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
        for(int i = 0; i < size; i++){
            System.out.println(arr[i] +" is at " + i  +"th index of array");
        }
        System.out.println("ArrayList print ended");
    }

}
