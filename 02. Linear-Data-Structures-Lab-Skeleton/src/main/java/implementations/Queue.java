package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {

    public static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
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
    private int size;

    @Override
    public void offer(E element) {
        Node<E> newNode = new Node<>(element, null, tail);

        // Проверка дали newNode е първи елемент.
        if (head == null) {
            // Ако е първи елемент newNode става head.
            head = newNode;
        }

        // Проверка дали newNode е първи елемент. Ако не е, влиза в if-a.
        if (this.tail != null) {
            this.tail.setNext(newNode);
        }

        tail = newNode;

        size++;
    }

    @Override
    public E poll() {
        if (!isEmpty()) {
            E firstElement = head.getElement();

            Node<E> nextNode = head.getNext();

            if (nextNode != null) {
                head = nextNode;
                nextNode.setPrev(null);
            } else {
                head = null;
                tail = null;
            }

            size--;

            return firstElement;
        }

        throw new IllegalStateException("Queue is empty.");
    }

    @Override
    public E peek() {

        if (!isEmpty()) {
            return head.getElement();
        }

        throw new IllegalStateException("Queue is empty.");
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
                return head == null;
            }

            @Override
            public E next() {
                return head.getElement();
            }
        };
    }
}
