package RegularExpressions.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String regex = "\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> matchedPhones = new ArrayList<>();

        while (matcher.find()) {
            matchedPhones.add(matcher.group(0));
        }

        System.out.println(String.join( ", ", matchedPhones));
    }
}
