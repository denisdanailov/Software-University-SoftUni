package Generics.Lab.ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2 ,3 ,4 ,5);

        Integer min = ListUtils.getMin(list);
        Integer max = ListUtils.getMax(list);

        System.out.println(min);
        System.out.println(max);
    }
}
