interface DequeADT<T> extends CollectionADT<T> {
    void pushFront(T value);
    void pushBack(T value);
    T popFront();
    T popBack();
    T front();
    T back();
    boolean swap(T v1, T v2);
}
