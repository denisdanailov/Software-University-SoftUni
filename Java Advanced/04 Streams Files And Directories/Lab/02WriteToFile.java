package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String path = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            int oneByte = inputStream.read();
            FileOutputStream outputStream = new FileOutputStream("WriteToFile.txt");

            Set<Character> charSet = Set.of(',', '.', '!', '?');
            while (oneByte != -1) {
                char oneByteAsChar = (char)oneByte;
                if (!charSet.contains(oneByteAsChar)) {
                    outputStream.write(oneByteAsChar);
                }
                oneByte = inputStream.read();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex2) {
            ex2.printStackTrace();
        }
    }
}
