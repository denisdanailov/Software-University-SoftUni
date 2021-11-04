package inheritance.lab.StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;
    private int lastIndex;

    public StackOfStrings() {
        this.data = new ArrayList<>();
        this.lastIndex = 0;
    }

    public void push(String item) {
        this.data.add(item);
        this.lastIndex++;
    }

    public String pop() {
        if (!this.data.isEmpty()) {
            return this.data.remove(this.lastIndex--);
        }
        return null;
    }

    public String peek() {
        if (!this.data.isEmpty()) {
            return this.data.get(this.lastIndex);
        }
        return null;
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
