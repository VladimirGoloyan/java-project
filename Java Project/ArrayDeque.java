import java.util.Iterator;

public class ArrayDeque<T> implements DequeADT<T> {
    private ArrayList<T> arr;

    public ArrayDeque() {
        arr = new ArrayList<T>();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public void empty() {
        arr.empty();
    }

    @Override
    public void print() {
        arr.print();
    }

    @Override
    public void pushFront(T value) {
        arr.addFirst(value);
    }

    @Override
    public void pushBack(T value) {
        arr.addLast(value);
    }

    @Override
    public T popFront() {
        T temp = arr.first();
        arr.removeFirst();
        return temp;
    }

    @Override
    public T popBack() {
        T temp = arr.last();
        arr.removeLast();
        return temp;
    }

    @Override
    public T front() {
        return arr.first();
    }

    @Override
    public T back() {
        return arr.last();
    }

    @Override
    public boolean swap(T v1, T v2) {
        return arr.swap(v1,v2);
    }

    @Override
    public Iterator<T> iterator() {
        return new myIterator<>();
    }

    private class myIterator<T> implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < arr.size();
        }

        @Override
        public T next() {
            return (T) arr.getElement(cursor++);
        }
    }
}
