interface CollectionADT<T> extends Iterable<T>{
    boolean isEmpty();

    void empty();

    int size();

    void print();
}