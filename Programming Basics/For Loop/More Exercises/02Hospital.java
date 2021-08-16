package ForLoop.MoreExercises;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int treatedPatients = 0;
        int untreatedPatients = 0;
        int doctors = 7;

        for (int i = 1; i <= n; i++) {
            int patients = Integer.parseInt(scan.nextLine());
            ;

            if (patients > doctors) {
                untreatedPatients += (patients - doctors);
                treatedPatients += doctors;
            } else {
                treatedPatients += patients;
            }

            if (i % 2 == 0) {
                if (untreatedPatients > treatedPatients) {
                    doctors++;
                }
            }
        }
        System.out.printf("Treated patients: %d.%n", treatedPatients);
        System.out.printf("Untreated patients: %d.%n", untreatedPatients);
    }
}
