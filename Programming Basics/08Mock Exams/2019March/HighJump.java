package MockExamsPB.March2019;

import java.util.Scanner;

public class HighJump {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int jumpHeight = Integer.parseInt(scan.nextLine());

        int attempt = 0;
        int countSum = 0;
        boolean flag = true;

        for (int i = jumpHeight - 30; i <= jumpHeight; i += 5) {
            int count = 0;
            for (int j = 1; j <= 3; j++) {
                attempt = Integer.parseInt(scan.nextLine());
                count++;
                if (attempt > i) {
                    break;
                }
                if (count == 3) {
                    flag = false;
                    break;
                }
            }
            countSum += count;
            if (!flag) {
                break;
            }
        }
        if (flag) {
            System.out.printf("Tihomir succeeded, he jumped over %dcm after %d jumps.", jumpHeight, countSum);
        } else {
            System.out.printf("Tihomir failed at %dcm after %d jumps.", jumpHeight, countSum);
        }
    }
}
