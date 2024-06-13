package algoJV.chapter1.section3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Steque<T> implements Iterable<T>{

    private Node<T> first;
    private int size;

    private static class Node<T> {
        private T item;
        private Node next;

        Node() {
            this.next = null;
        }
    }

    private static class LinkedListIterator<T> implements Iterator<T> {
        private Node<T> current;

        LinkedListIterator(Node<T> first) {
            this.current = first;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    Steque() {
        first = null;
        size = 0;
    }

    public void push(T item) {
        Node<T> old = first;
        first = new Node<T>();
        first.item = item;
        first.next = old;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException();
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public void enqueue(T item) {
        Node<T> newN = new Node<T>();
        newN.item = item;

        if (first == null) {
            first = newN;
            return;
        }

        Node<T> tmp = first;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newN;
        size++;
    }

    public Boolean isEmpty() {
        if (this.size == 0) return true;
        return false;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this) {
            s.append(item);
            s.append(" ");
        }
        return s.toString();
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(first);
    }
}
