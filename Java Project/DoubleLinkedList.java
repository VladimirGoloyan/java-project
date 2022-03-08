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

    public int size() {
        return size;
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
        size = 0;
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
            size++;
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

    public boolean swap(T v1, T v2) {
        Node n1 = findNode(v1);
        Node n2 = findNode(v2);

        if (n1 == null || n2 == null) {
            return false;
        }

        if (n1.value == n2.value) {
            return true;
        }

        Node temp;

        temp = n1.next;
        n1.next = n2.next;
        n2.next = temp;

        if (n1.next != null)
            n1.next.prev = n1;
        if (n2.next != null)
            n2.next.prev = n2;

        temp = n1.prev;
        n1.prev = n2.prev;
        n2.prev = temp;

        if (n1.prev != null)
            n1.prev.next = n1;
        if (n2.prev != null)
            n2.prev.next = n2;

        return true;
    }

    public Node findNode(T value) {
        Node temp = first;

        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
        }
        return null;
    }

    public T getElement(int index) {
        if (index > -1 && index < size) {
            Node temp = first;

            while (index < size) {
                temp = temp.next;
            }

            return (T) temp.value;
        }
        return null;
    }

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
        private DoubleLinkedList<T>.Node<T> temp = (DoubleLinkedList<T>.Node<T>) first;

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
        private DoubleLinkedList<T>.Node<T> temp = (DoubleLinkedList<T>.Node<T>) first.next;

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
