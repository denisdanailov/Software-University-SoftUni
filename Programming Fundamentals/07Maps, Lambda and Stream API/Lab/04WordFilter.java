package AssociativeArrays.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> filteredWords = Arrays.stream(scan.nextLine().split(" "))
                .filter(w -> w.length() % 2 == 0)
                .collect(Collectors.toList());

        for (String word:
             filteredWords) {
            System.out.println(word);
        }
    }
}
