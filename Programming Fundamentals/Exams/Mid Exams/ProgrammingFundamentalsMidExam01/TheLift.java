package Exams.MidExam.ProgrammingFundamentalsMidExam01;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scan.nextLine());

        int[] wagonArr = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 15
        //0 0 0 0
        int availableSeats = 0;
        for (int i = 0; i < wagonArr.length; i++) {
            if (wagonArr[i] < 4) {
                availableSeats = 4 - wagonArr[i];
                if (peopleWaiting >= availableSeats) {
                    wagonArr[i] += availableSeats;
                    peopleWaiting -= availableSeats;
                } else {
                    wagonArr[i] += peopleWaiting;
                    peopleWaiting = 0;
                }
            }
        }

        boolean emptySpots = false;
        for (int wagon:
             wagonArr) {
            if (wagon < 4) {
                emptySpots = true;
            }
        }

      if (peopleWaiting <= 0 && emptySpots) {
          System.out.println("The lift has empty spots!");
          for (int i = 0; i < wagonArr.length; i++) {
              if (i != wagonArr.length -1) {
                  System.out.print(wagonArr[i] + " ");
              } else {
                  System.out.print(wagonArr[i]);
              }
          }
      } else if (peopleWaiting > 0 && !emptySpots) {
          System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
          for (int i = 0; i < wagonArr.length; i++) {
              if (i != wagonArr.length -1) {
                  System.out.print(wagonArr[i] + " ");
              } else {
                  System.out.print(wagonArr[i]);
              }
          }
      } else if (!emptySpots) {
          for (int i = 0; i < wagonArr.length; i++) {
              if (i != wagonArr.length -1) {
                  System.out.print(wagonArr[i] + " ");
              } else {
                  System.out.print(wagonArr[i]);
              }
          }
      }
    }
}
