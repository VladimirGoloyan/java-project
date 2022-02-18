import java.util.Iterator;

public class DoubleLinkedList<T> implements ListADT<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    private class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T t) {
            value = t;
            next = null;
            prev = null;
        }

        public Node(T t, Node<T> w, Node<T> s) {
            value = t;
            next = w;
            prev = s;
        }
    }

    public DoubleLinkedList() {
        size = 0;
        first = last = null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

    @Override
    public void empty() {
        // TODO Auto-generated method stub
        first = last = null;
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        Node<T> temp = first;
        System.out.println("Starting to print DoubleLinkedList");
        while (temp.next != null) {
            System.out.println(temp.value);
        }
        System.out.println("Printing DoubleLinkedList ended");
    }

    @Override
    public void addFirst(T e) {
        // TODO Auto-generated method stub
        if (size == 0) {
            first = last = new Node(e, null, null);
            return;
        }

        Node<T> temp = new Node(e, first, null);
        first = temp;
        size++;
    }

    @Override
    public boolean removeFirst() {
        // TODO Auto-generated method stub
        if (size == 0) {
            return false;
        }

        first = first.next;
        first.prev = null;
        size--;
        return true;
    }

    @Override
    public void addLast(T e) {
        if (size == 0) {
            first = last = new Node(e, null, null);
            return;
        }

        Node<T> temp = new Node(e, null, last);
        last = temp;
        size++;

    }

    @Override
    public boolean removeLast() {
        if (size == 0) {
            return false;
        }

        last = last.prev;
        last.next = null;
        size--;
        return true;
    }

    @Override
    public T first() {
        // TODO Auto-generated method stub
        return first.value;
    }

    @Override
    public T last() {
        // TODO Auto-generated method stub
        return last.value;
    }

    @Override
    public boolean replace(T e, T r) {
        // TODO Auto-generated method stub
        if (size == 0) {
            return false;
        }

        Node<T> temp = first;

        while (temp.next != null) {
            if (temp.value == e) {
                temp.value = r;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }


     public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new ForwardIterator();
    }

    public Iterator<T> OddIterator() {
        // TODO Auto-generated method stub
        if(size < 2){
            return null;
        }
        return new MyOddIterator();
    }

    private class ForwardIterator<T> implements Iterator<T> {      
        private Node<T> temp = first;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return temp != null;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            T res = temp.value;
            temp = temp.next;
            return res;
        }

    }

    private class MyOddIterator<T> implements Iterator<T> {
        private Node<T> temp = first.next;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return temp != null;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            T res = temp.value;
            temp = temp.next.next;
            return res;
        }
    }
}
