package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {

    public static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> previous;

        public E getElement() {
            return element;
        }

        public Node(E element, Node<E> next, Node<E> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;


    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element, this.head, null);

        // Ако newNode не е първият елемент в структурата, влизаме в if-a.
        if (this.head != null) {
            this.head.setPrevious(newNode);
        }

        this.head = newNode;

        size++;
    }

    @Override
    public void addLast(E element) {

        Node<E> newNode = new Node<>(element,null, this.tail);

        if (head == null) {
            this.head = newNode;
        }

        if (this.tail != null) {
            this.tail.setNext(newNode);
        }

        this.tail = newNode;

        size++;
    }

    @Override
    public E removeFirst() {
        Node<E> firstElement = this.head;

        if (firstElement.getNext() != null) {
            this.head = firstElement.getNext();
            firstElement.getNext().setPrevious(null);
        } else {
            this.head = null;
            this.tail = null;
        }

        size--;

        return firstElement.getElement();
    }

    @Override
    public E removeLast() {
        Node<E> lastElement = this.tail;

        if (lastElement.getPrevious() != null) {
            lastElement.getPrevious().setNext(null);
            this.tail = lastElement.getPrevious();
        } else {
            this.head = null;
            this.tail = null;
        }

        size--;

        return lastElement.getElement();
    }

    @Override
    public E getFirst() {
        return this.head.getElement();
    }

    @Override
    public E getLast() {
        return this.tail.getElement();
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
        return null;
    }
}
