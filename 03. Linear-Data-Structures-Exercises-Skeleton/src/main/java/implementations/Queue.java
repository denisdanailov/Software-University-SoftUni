package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        private Node(E element) {
            this.element = element;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public void offer(E element) {
        Node<E> newNode = new Node<>(element);

        if (this.head == null) {
            this.head = this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
    }

    @Override
    public E poll() {
        ensureNonEmpty();

        E element = this.head.getElement();

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node<E> next = this.head.getNext();
            this.head.setNext(null);
            this.head = next;
        }

        this.size--;

        return element;
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return this.head.getElement();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public E next() {
                E element = this.current.getElement();
                this.current = this.current.getNext();
                return element;
            }
        };
    }

    private void ensureNonEmpty() {
        if (this.size == 0) {
            throw new IllegalStateException("Illegal operation on empty stack");
        }
    }
}
