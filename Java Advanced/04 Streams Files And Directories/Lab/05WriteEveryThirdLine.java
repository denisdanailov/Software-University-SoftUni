package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) {

        String path = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Scanner scan = new Scanner(inputStream);

            PrintStream printStream = new PrintStream("WriteEveryThirdLine.txt");
            int count = 0;
            String input = scan.nextLine();
            while (scan.hasNextLine()) {
                count += 1;
                if (count % 3 == 0) {
                    printStream.println(input);
                }
                input = scan.nextLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
