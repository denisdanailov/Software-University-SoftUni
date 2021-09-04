package Generics.Lab.JarOfT;

import java.util.ArrayDeque;

public class Jar <Type> {

    private ArrayDeque<Type> stack;

    public Jar() {
        this.stack = new ArrayDeque<>();
    }

    public void add(Type element) {
        stack.push(element);
    }

    public Type remove() {
        return stack.pop();
    }
}
