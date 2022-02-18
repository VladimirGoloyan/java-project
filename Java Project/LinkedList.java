import java.util.Iterator;

public class LinkedList<T> implements ListADT<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T t) {
            value = t;
            next = null;
        }

        public Node(T t, Node<T> w) {
            value = t;
            next = w;
        }
    }

    public LinkedList() {
        size = 0;
        first =  last = null;
    }

    public void addFirst(T el) {
        if (size == 0) {
            last = first = new Node<T>(el);
            size++;
        } else {
            first = new Node(el, first);
        }
        size++;
    }

    public void addLast(T el) {
        if (size == 0) {
            last = first = new Node(el);
            size++;
        } else {
            Node temp = new Node(el, null);
            last.next = temp;
            last = temp;
            size++;
        }
        size++;
    }

    public boolean removeLast() {
        if (size == 0) {
            return false;
        }
        if (first == last) {
            first = last = null;
            size--;
            return true;
        }

        Node<T> temp = first;

        while (temp.next != last) {
            temp = temp.next;
        }

        temp.next = null;
        last = temp;
        size--;

        return true;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

    @Override
    public void empty() {
        first = last = null;
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        Node temp = first;
        System.out.println("Starting to print LinkedList");
        while (temp.next != null) {
            System.out.println(temp.value);
        }
        System.out.println("Printing LinkedList ended");
    }

    @Override
    public boolean removeFirst() {
        // TODO Auto-generated method stub
        if (size == 0) {
            return false;
        }
        if (first == last) {
            first = last = null;
            size--;
            return true;
        }

        first = first.next;
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
