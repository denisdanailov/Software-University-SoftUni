package solidPrinciples.exercises.logger;

import java.util.Scanner;

public class InputParser {

    public String readLoggerInfo(Scanner scan) {
        int n = Integer.parseInt(scan.nextLine());
        StringBuilder strBuild = new StringBuilder();

        while (n-- > 0) {
            strBuild.append(scan.nextLine()).append(System.lineSeparator());
        }

        return strBuild.toString().trim();
    }
}
