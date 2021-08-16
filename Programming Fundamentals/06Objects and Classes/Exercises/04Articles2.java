package ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2 {

    public static class Article {
        String title;
        String content;
        String author;

        public Article(String input1, String input2, String input3) {
            this.title = input1;
            this.content = input2;
            this.author = input3;
        }

        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Article> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String input = scan.nextLine();

            String[] tokens = input.split(", ");

            Article newArticle = new Article(tokens[0], tokens[1], tokens[2]);

            list.add(newArticle);
        }

        String order = scan.nextLine();

        switch (order) {
            case "title":
                list.stream()
                        .sorted((a1,a2) -> a1.title.compareTo(a2.title))
                        .forEach(Article -> System.out.println(Article.toString()));
                break;
            case "content":
                list.stream()
                        .sorted((a1,a2) -> a1.content.compareTo(a2.content))
                        .forEach(Article -> System.out.println(Article.toString()));
                break;
            case "author":
                list.stream()
                        .sorted((a1,a2) -> a1.author.compareTo(a2.author))
                        .forEach(Article -> System.out.println(Article.toString()));
                break;
        }

    }
}
