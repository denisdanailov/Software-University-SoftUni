package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class CopyBytes {
    public static void main(String[] args) {

        String path = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);

            int oneByte = inputStream.read();

            FileOutputStream outputStream = new FileOutputStream("CopyBytes.txt");

            Set<Character> charSet = Set.of(' ', '\n');
            while (oneByte != -1) {
                char oneByteAsChar = (char) oneByte;
                if (charSet.contains(oneByteAsChar)) {
                    outputStream.write(oneByteAsChar);
                } else {
                    String digit = Integer.toString(oneByte);
                    for (int i = 0; i < digit.length(); i++) {
                        outputStream.write(digit.charAt(i));
                    }
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
