package Exams.FinalExams.ProgrammingFundamentalsFinalExam03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        //Regex
        Pattern regex = Pattern.compile("(#|@)(?<firstWord>[A-Za-z]{3,})\\1{2}(?<secondWord>[A-Za-z]{3,})\\1");
        Matcher matcher = regex.matcher(text);

        Map<String, String> pairMap = new LinkedHashMap<>();
        Map<String, String> mirrorWordMap = new LinkedHashMap<>();

        boolean validPairs = false;
        boolean mirrorWords = false;
        //Логиката
        while (matcher.find()) {
            validPairs = true;
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            StringBuilder strBuild = new StringBuilder(secondWord);
            if (firstWord.equals(strBuild.reverse().toString())){
                mirrorWords= true;
                mirrorWordMap.put(firstWord, secondWord);
                pairMap.put(firstWord, secondWord);
            } else {
                pairMap.put(firstWord, secondWord);
            }
        }
        //Принтене
        if (validPairs) {
            System.out.printf("%d word pairs found!%n", pairMap.size());
        } else {
            System.out.println("No word pairs found!");
        }
        if (mirrorWords) {
            System.out.println("The mirror words are:");
            int counter = 0;
            for (Map.Entry<String, String> entrySet : mirrorWordMap.entrySet()) {
                counter += 1;
                if (counter != mirrorWordMap.size()) {
                    System.out.print(entrySet.getKey() + " <=> " + entrySet.getValue() + ", ");
                } else {
                    System.out.print(entrySet.getKey() + " <=> " + entrySet.getValue());
                }
            }
        } else {
            System.out.println("No mirror words!");
        }
    }
}
