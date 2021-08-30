package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String path = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            int oneByte = inputStream.read();
            while (oneByte != -1) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = inputStream.read();
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
