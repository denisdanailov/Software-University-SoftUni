package inheritance.lab.randomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> list = new RandomArrayList<>();

        for (int i = 0; i < 16; i++) {
            list.add(i);
        }

        int randomElement = list.getRandomElement();

        System.out.println(randomElement);
    }
}
