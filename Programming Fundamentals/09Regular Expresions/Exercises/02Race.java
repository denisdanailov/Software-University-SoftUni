package RegularExpressions.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> raceMap = new LinkedHashMap<>();

        String[] racers = scan.nextLine().split(", ");
        Arrays.stream(racers).forEach(r -> raceMap.put(r,0));

        String input = scan.nextLine();
        String LettersRegex = "[A-Za-z]";
        String NumbersRegex = "\\d";
        Pattern lettersPattern = Pattern.compile(LettersRegex);
        Pattern numbersPattern = Pattern.compile(NumbersRegex);

        while (!input.equals("end of race")) {
            Matcher lettersMatcher = lettersPattern.matcher(input);
            Matcher numbersMatcher = numbersPattern.matcher(input);

            StringBuilder name = new StringBuilder();
            while (lettersMatcher.find()) {
                name.append(lettersMatcher.group());
            }

            int kmRun = 0;
            while (numbersMatcher.find()) {
                kmRun += Integer.parseInt(numbersMatcher.group());
            }

            if (raceMap.containsKey(name.toString())) {
                int currentValue = raceMap.get(name.toString());
                raceMap.replace(name.toString(),currentValue + kmRun);
            }

            input = scan.nextLine();
        }

        List<String> winnersList = raceMap.entrySet().stream()
                .sorted((first, second) -> Integer.compare(second.getValue(),first.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        int place = 0;
        for (String winner:
             winnersList) {
        place += 1;
        switch (place) {
            case 1:
                System.out.println("1st place: " + winner);
                break;
            case 2:
                System.out.println("2nd place: " + winner);
                break;
            case 3:
                System.out.println("3rd place: " + winner);
                break;
        }
        }
    }
}
