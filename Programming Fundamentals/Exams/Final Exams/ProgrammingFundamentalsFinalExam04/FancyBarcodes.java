package Exams.FinalExams.ProgrammingFundamentalsFinalExam04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Pattern regex = Pattern.compile("@#+[A-Z][A-Za-z\\d]{4,}[A-Z]@#+");
            Matcher barcode = regex.matcher(input);
            //Проверка дали баркода е валиден
            if (barcode.find()) {
                regex = Pattern.compile("\\d");
                barcode = regex.matcher(input);
                StringBuilder productGroup = new StringBuilder();
                //Извличане на числата от баркода
                while (barcode.find()) {
                    productGroup.append(barcode.group());
                }
                //Проверка за групите
                if (productGroup.length() == 0) {
                    System.out.printf("Product group: %s%n", "00");
                } else {
                    System.out.printf("Product group: %s%n", productGroup.toString());
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
