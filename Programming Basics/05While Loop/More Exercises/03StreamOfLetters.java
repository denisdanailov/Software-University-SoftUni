package WhileLoop.MoreExercises;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        char symbol = 0;
        String word = "";

        boolean o = false;
        boolean c = false;
        boolean n = false;


        while (!input.equals("End")) {

            symbol = input.charAt(0);

            if ((symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z')) {

                switch (symbol) {
                    case 'o':
                        if (o) {
                            word += symbol;
                        }
                        o = true;
                        break;
                    case 'c':
                        if (c) {
                            word += symbol;
                        }
                        c = true;
                        break;
                    case 'n':
                        if (n) {
                            word += symbol;
                        }
                        n = true;
                        break;
                    default:
                        word += symbol;
                        break;
                }
                if (o && c && n) {

                    System.out.print(word + " ");

                    o = false;
                    c = false;
                    n = false;

                    word = "";
                }
            }

            input = scan.nextLine();
        }
    }
}
