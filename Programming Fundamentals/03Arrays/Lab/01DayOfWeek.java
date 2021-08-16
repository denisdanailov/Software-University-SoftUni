package Arrays.Labs;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[] days = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
//        days[0] = "Monday";
//        days[1] = "Tuesday";
//        days[2] = "Wednesday";
//        days[3] = "Thursday";
//        days[4] = "Friday";
//        days[5] = "Saturday";
//        days[6] = "Sunday";

        if (n >=1 && n <= 7) {
            System.out.println(days[n-1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
