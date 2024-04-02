package org.example.list;

public interface MyList<T> {

    void add(T element);

    T remove(int index);

    boolean addAll(MyList<? extends T> collection);

    T get(int index);

    int getSize();
}
