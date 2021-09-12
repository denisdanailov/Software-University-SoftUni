package Generics.Lab.ListUtilities;

import java.util.List;

public class ListUtils <Type> {

    public static <Type extends Comparable<Type>> Type getMin (List<Type> list) {
        if (list.size() == 0) {
         throw new IllegalArgumentException();
        }

        Type min = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (min.compareTo(list.get(i)) > 0) {
                min = list.get(i);
            }
        }

        return min;
    }

    public static <Type extends Comparable<Type>> Type getMax (List<Type> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }

        Type max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (max.compareTo(list.get(i)) < 0) {
                max = list.get(i);
            }
        }

        return max;
    }
}
