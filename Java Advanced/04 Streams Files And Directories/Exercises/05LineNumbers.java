package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        // Reading from file
        String url = "C:\\Users\\Olegati\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputLineNumbers.txt";
        Path path = Path.of(url);
        List<String> list = Files.readAllLines(path);
        // Writing to file (opening output stream)
        BufferedWriter writer = new BufferedWriter(new FileWriter("LineNumbers.txt"));
        for (int i = 0; i < list.size(); i++) {
            writer.write(String.format("%d. %s", i + 1, list.get(i)));
            writer.newLine();
        }
        // Closing output stream
        writer.close();
    }
}
