package Exams.FinalExams.ProgrammingFundamentalsFinalExam02;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String stops = scan.nextLine();
        String initialStops = stops;

        String input = scan.nextLine();
        while (!input.equals("Travel")) {
            String[] tokens = input.split(":");
            String action = tokens[0];
            switch (action) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String string = tokens[2];
                    if (indexIsValid(stops, index)) {
                        StringBuilder strBuild = new StringBuilder(stops);
                        strBuild.insert(index, string);
                        stops = strBuild.toString();
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (indexIsValid(stops, startIndex) && indexIsValid(stops, endIndex)) {
                        StringBuilder strBuild = new StringBuilder(stops);
                        for (int i = endIndex; i >= startIndex; i--) {
                            strBuild.deleteCharAt(i);
                        }
                        stops = strBuild.toString();
                    }
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    if (stops.contains(oldString)) {
                        stops = stops.replaceAll(oldString, newString);
                    }
                    break;
            }
            System.out.println(stops);
            input = scan.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s%n", stops);
    }

    public static boolean indexIsValid(String input, int index) {
        if (index >= 0 && index < input.length()) {
            return true;
        }
        return false;
    }
}
