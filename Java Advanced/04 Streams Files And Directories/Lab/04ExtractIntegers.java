package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {

        String path = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Scanner scan = new Scanner(inputStream);

            PrintStream printStream = new PrintStream("ExtractIntegers.txt");

            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    printStream.println(scan.nextInt());
                }
                scan.next();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
