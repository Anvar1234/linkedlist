package org.example.anvarlinkedlist;

public interface AnvarList<T> extends Iterable<T>{
    void add(T t);
    void remove (T t);
    T get(int index);
    T set(int index, T t);
    int size();


}
