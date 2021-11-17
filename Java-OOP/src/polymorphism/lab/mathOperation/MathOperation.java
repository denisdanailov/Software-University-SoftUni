package polymorphism.lab.mathOperation;

public class MathOperation {

    public int add(int fst, int snd) {
        return fst + snd;
    }

    public int add(int fst, int snd, int trd) {
        return add(add(fst, snd), trd);
    }

    public int add(int fst, int snd, int trd, int fth) {
        return add(add(fst, snd, trd), fth);
    }
}
