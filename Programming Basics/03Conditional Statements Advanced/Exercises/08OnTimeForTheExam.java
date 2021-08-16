package AdvConditionalStatements.Exercises;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int examHour = Integer.parseInt(scan.nextLine());
        int examMinutes = Integer.parseInt(scan.nextLine());
        int arrivalHour = Integer.parseInt(scan.nextLine());
        int arrivalMinutes = Integer.parseInt(scan.nextLine());

        int examTime = (examHour * 60) + examMinutes;
        int arrivalTime = (arrivalHour * 60) + arrivalMinutes;
        String output = "";
        String output2 = "";
        int difference = 0;

        if (arrivalTime < (examTime - 30)) {
            output ="Early";
            difference = examTime - arrivalTime;
            if (difference < 60) {
                output2 = String.format("%d minutes before the start", difference);
            } else {
                int hours = difference / 60;
                int minutes = difference % 60;
                output2 = String.format("%d:%02d hours before the start", hours, minutes);
            }
        } else if (arrivalTime <= examTime) {
            output= "On time";
            difference = examTime - arrivalTime;
            output2 = String.format("%d minutes before the start", difference);
        } else if (arrivalTime > examTime){
            output = "Late";
            difference = arrivalTime - examTime;
            if (difference < 60) {
                output2 = String.format("%d minutes after the start", difference);
            } else {
                int hours = difference / 60;
                int minutes = difference % 60;
                output2 = String.format("%d:%02d hours after the start", hours, minutes);
            }
        }
        System.out.println(output);
        System.out.println(output2);
    }
}
