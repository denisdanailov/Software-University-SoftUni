package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;

public class Stack<E> implements AbstractStack<E> {

    public static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    int size;

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element, null, tail);

        if (head == null) {
            head = newNode;
        }

        // Ако tail реферира към обект от тип Node, a не сочи null, влизаш в if-a.
        if (tail != null) {
            tail.setNext(newNode);
        }

        tail = newNode;

        size++;
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            E lastElement = tail.getElement();

           if (tail.getPrev() != null) {
               tail = tail.getPrev();
           } else {
               head = null;
               tail = null;
           }

            size--;

            return lastElement;
        }

        throw new IllegalStateException("Stack is empty.");
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return tail.getElement();
        }

        throw new IllegalStateException("Stack is empty.");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            @Override
            public boolean hasNext() {
                return tail == null;
            }

            @Override
            public E next() {
                return tail.getElement();
            }
        };
    }
}
