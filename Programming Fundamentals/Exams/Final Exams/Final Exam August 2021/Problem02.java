package Exams.FinalExams.FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
          String input = scan.nextLine();
          Pattern regex = Pattern.compile("[|](?<bossName>[A-Z]{4,})[|]:[#](?<title>[A-Za-z]+\\s[A-Za-z]+)[#]");
          Matcher matcher = regex.matcher(input);

          if (matcher.find()) {
              String bossName = matcher.group("bossName");
              String title = matcher.group("title");
              System.out.printf("%s, The %s%n", bossName, title);
              System.out.printf(">> Strength: %d%n", bossName.length());
              System.out.printf(">> Armor: %d%n", title.length());
          } else {
              System.out.println("Access denied!");
          }
        }
    }
}
