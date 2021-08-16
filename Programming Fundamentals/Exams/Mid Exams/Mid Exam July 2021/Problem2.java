package Exams.MidExam.ProgrammingFundamentalsMidExamJuly21;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> genres = Arrays.stream(scan.nextLine().split(" \\| ")).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Stop!")) {
            String[] tokens = input.split(" ");
            String action = tokens[0];
            String genre = "";
            String oldGenre = "";
            String newGenre = "";
            switch (action) {
                case "Join":
                    genre = tokens[1];
                    if (!genres.contains(genre)) {
                        genres.add(genre);
                    }
                    break;
                case "Drop":
                    genre = tokens[1];
                    if (genres.contains(genre)) {
                        genres.remove(genre);
                    }
                    break;
                case "Replace":
                    oldGenre = tokens[1];
                    newGenre = tokens[2];
                    if (genres.contains(oldGenre) && !genres.contains(newGenre)) {
                        genres.set(genres.indexOf(oldGenre),newGenre);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        for (int i = 0; i < genres.size(); i++) {
            if (i != genres.size() - 1) {
                System.out.print(genres.get(i) + " ");
            } else {
                System.out.print(genres.get(i));
            }
        }
    }
}
