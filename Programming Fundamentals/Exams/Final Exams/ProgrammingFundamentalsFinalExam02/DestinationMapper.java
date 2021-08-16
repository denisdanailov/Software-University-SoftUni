package Exams.FinalExams.ProgrammingFundamentalsFinalExam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Pattern regex = Pattern.compile("(=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = regex.matcher(input);

        List<String> destinationList = new ArrayList<>();
        int travelPoints = 0;
        while (matcher.find()) {
            destinationList.add(matcher.group("destination"));
            travelPoints += matcher.group("destination").length();
        }

        if (destinationList.size() > 0) {
            System.out.print("Destinations: ");
        } else {
            System.out.println("Destinations: ");
        }
        for (int i = 0; i < destinationList.size(); i++) {
            if (i != destinationList.size() - 1) {
                System.out.printf("%s, ", destinationList.get(i));
            } else {
                System.out.println(destinationList.get(i));
            }
        }

        System.out.println("Travel Points: " + travelPoints);
    }
}
