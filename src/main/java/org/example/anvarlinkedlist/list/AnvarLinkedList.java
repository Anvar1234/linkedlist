package org.example.anvarlinkedlist.list;

import org.example.anvarlinkedlist.AnvarList;

import java.util.Iterator;
import java.util.Objects;

public class AnvarLinkedList<T> implements AnvarList<T>, Iterable<T> {
    private Node<T> head;
    private int size;

    public AnvarLinkedList() {
        this.head = null;
        this.size = 0;
    }


    private static class Node<T> {
        private T data;
        private Node<T> next;


        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return data.equals(node.data);
        }

        @Override
        public int hashCode() {
            int prime = 31;
            return prime * Objects.hash(data);
        }
    }


    @Override
    public void add(T element) {
        if (head == null) {
            head = new Node<>(element);
        } else {
            Node<T> tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = new Node<>(element);
        }
        size++;
    }

    //удаление по содержанию (не индексу). Удаляет все equals значения. Если элемент последний - ошибка.
    //При этом size отображается некорректно.
    @Override
    public void remove(T element) {
        if (head.data.equals(element)) {
            head = head.next;
        }
        Node<T> tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.next.data.equals(element)) {
                tempNode.next = tempNode.next.next;
                size--;
            }
            tempNode = tempNode.next;
        }
    }


    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                return head.data;
            }
            Node<T> tempNode = head;
            int i = 0;
            while (i != index) {
                tempNode = tempNode.next;
                i++;
            }
            return tempNode.data;
        }
        return null; //как НЕ возвращать null?
    }

    @Override
    public T set(int index, T t) { //вставка с заменой элемента и возвратом его предыдущего значения.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(); //На что заменить этот блок if? try-catch? Какое исключение там прописать?
        }
        if (index == 0) {
            T oldData = head.data;
            head.data = t;
            return oldData;
        }
        Node<T> tempNode = head;
        int i = 0;
        while (i != index) {
            tempNode = tempNode.next;
            i++;
        }
        T oldData = tempNode.data;
        tempNode.data = t;
        return oldData;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public String toString() {
        return "AnvarLinkedList{" +
                "first=" + head +
                '}';
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return head != null;
            }

            //не понял логику.
            @Override
            public T next() {
                Node<T> tempNode = head;
                head = head.next;
                return tempNode.data;
            }
        };
    }
}
