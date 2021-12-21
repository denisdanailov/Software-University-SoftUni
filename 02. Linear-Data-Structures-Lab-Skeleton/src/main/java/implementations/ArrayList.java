package implementations;

import interfaces.List;

import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    Object[] array;
    int size;

    public ArrayList() {
        this.array = new Object[1];
        this.size = 0;
    }

    private boolean isIndexInBounds(Object[] array, int index) {
        if (index >= 0 && index < size) {
            return true;
        }
        return false;
    }

    @Override
    public boolean add(E element) {
        if (size >= array.length) {
            Object[] newArr = new Object[this.array.length * 2];

            for (int i = 0; i < array.length; i++) {
                newArr[i] = array[i];
            }

            newArr[size++] = element;

            array = newArr;
        } else {
            array[size++] = element;
        }

        return true;
    }

    @Override
    public boolean add(int index, E element) {
        if (isIndexInBounds(array, index)) {
            if (size >= array.length) {

                Object[] newArr = new Object[array.length * 2];

                for (int i = 0; i < index; i++) {
                    newArr[i] = array[i];
                }

                newArr[index] = element;

                for (int i = index; i < array.length; i++) {
                    newArr[i + 1] = array[i];
                }

                array = newArr;
            } else {

                for (int i = array.length - 1; i > index; i--) {
                    array[i] = array[i - 1];
                }

                array[index] = element;

            }

            size++;

            return true;

        }

        return false;
    }

    @Override
    public E get(int index) {

        if (isIndexInBounds(array, index)) {

            return (E) array[index];

        }

        throw new IndexOutOfBoundsException("Invalid Index.");

    }

    @Override
    public E set(int index, E element) {
        if (isIndexInBounds(array, index)) {
            Object prevElement = array[index];

            array[index] = element;

            return (E) prevElement;
        }
        throw new IndexOutOfBoundsException("Invalid Index.");
    }

    @Override
    public E remove(int index) {
        if (isIndexInBounds(array, index)) {
            Object currElement = array[index];

            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }

            array[size - 1] = null;

            size--;

            return (E) currElement;
        }
        throw new IndexOutOfBoundsException("Invalid Index.");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {

        if (size > 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(element)) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public boolean contains(E element) {

        if (size > 0) {
            for (Object o : array) {
                if (o.equals(element)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < size;
            }

            @Override
            public E next() {
                return get(index++);
            }


        };
    }
}
