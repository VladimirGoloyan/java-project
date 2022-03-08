import java.util.Iterator;

public class DLLDeque<T> implements DequeADT<T> {

    private DoubleLinkedList<T> list;

    public DLLDeque() {
        list = new DoubleLinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void empty() {
        list.empty();
    }

    @Override
    public void print() {
        System.out.println("Printing DoubleLinkedList Deque");
        Iterator it = iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("End of DoubleLinkedList Deque");
    }

    @Override
    public void pushFront(T value) {
        list.addFirst(value);
    }

    @Override
    public void pushBack(T value) {
        list.addLast(value);
    }

    @Override
    public T popFront() {
        T temp = list.first();
        list.removeFirst();
        return temp;
    }

    @Override
    public T popBack() {
        T temp = list.last();
        list.removeLast();
        return temp;
    }

    @Override
    public T front() {
        return list.first();
    }

    @Override
    public T back() {
        return list.last();
    }

    @Override
    public boolean swap(T v1, T v2) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new myIterator<>();
    }

    private class myIterator<T> implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < list.size();
        }

        @Override
        public T next() {
            return (T) list.getElement(cursor++);
        }
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return list.size();
    }
}
