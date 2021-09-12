package Generics.Lab.GenericScale;

public class Scale <Type extends Comparable<Type>> {
    private Type left;
    private Type right;

    public Scale(Type left, Type right) {
        this.left = left;
        this.right = right;
    }

    public Type getHeavier() {
        if (this.left.compareTo(this.right) == 0) {
            return null;
        } else if (this.left.compareTo(this.right) < 0) {
            return right;
        }
        return left;
    }
}
