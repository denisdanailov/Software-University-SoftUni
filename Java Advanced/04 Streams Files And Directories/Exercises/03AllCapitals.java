package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String localPath = "C:\\Users\\Olegati\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\input.txt";

        Path path = Path.of(localPath);
        List<String> listLines = Files.readAllLines(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter("AllCapitals.txt"));
        List<String> newListLines = new ArrayList<>();
        for (int i = 0; i < listLines.size(); i++) {
            newListLines.add(listLines.get(i).toUpperCase());
        }
        newListLines.forEach(line -> {
            try {
                writer.write(line);
                writer.newLine();
            } catch (IOException ioException) {
                System.out.println("Error");
            }
        });

        writer.close();
    }
}
