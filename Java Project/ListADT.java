public interface ListADT<T> extends CollectionADT<T> {
    void addFirst(T e);

    boolean removeFirst();

    void addLast(T e);

    boolean removeLast();

    T first();

    T last();

    boolean replace(T e, T r);
}
