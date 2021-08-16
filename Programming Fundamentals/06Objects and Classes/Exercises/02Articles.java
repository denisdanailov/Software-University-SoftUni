package ObjectsAndClasses.Exercise;

import java.util.Scanner;

public class Articles {

    public static class Article {
        String title;
        String content;
        String author;

        public Article(String input1, String input2, String input3) {
            this.title = input1;
            this.content = input2;
            this.author = input3;
        }

         public void setContent(String newContent){
            this.content = newContent;
        }
        public void setAuthor(String newAuthor) {
        this.author = newAuthor;
        }
        public void setTitle(String newTitle) {
            this.title = newTitle;
        }

        public String toString(){
        return this.title + " - " + this.content + ": " + this.author;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String[] elements = input.split(", ");

        Article orgArticle = new Article (elements[0], elements[1], elements[2]);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {

            String action = scan.nextLine();

            String[] tokens = action.split(": ");

            switch (tokens[0]){
                case "Edit":
                    orgArticle.setContent(tokens[1]);
                    break;
                case "ChangeAuthor":
                    orgArticle.setAuthor(tokens[1]);
                    break;
                case "Rename":
                    orgArticle.setTitle(tokens[1]);
                    break;
            }
        }

        System.out.println(orgArticle.toString());
    }
}
