package Arrays.MoreExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = scan.nextLine();
        }

        int[] encryptedNames = new int[n];

        for (int i = 0; i < n; i++) {
            int vowelSum = 0;
            int consonantSum =0;
            for (int j = 0; j < names[i].length(); j++) {
               char letter = names[i].charAt(j);
                if (letter == 'A'|| letter == 'O' || letter == 'U' || letter == 'E' || letter == 'I' || letter == 'a'|| letter == 'o' || letter == 'u' || letter == 'e' || letter == 'i') {
                    vowelSum += names[i].length() * letter;
                } else {
                    consonantSum += letter / names[i].length();
                }
            }
            encryptedNames[i] = vowelSum + consonantSum;
        }
        // Ascending order method
        Arrays.sort(encryptedNames);

        Arrays.stream(encryptedNames)
                .forEach(System.out::println);

        // Descending order
//        int[] descendingEncryptedNames = new int[n];
//        int index = 0;
//        for (int i = encryptedNames.length - 1; i >= 0 ; i--) {
//            descendingEncryptedNames[index] = encryptedNames[i];
//            index++;
//        }
//        Arrays.stream(descendingEncryptedNames).forEach(System.out::println);

    }
}
