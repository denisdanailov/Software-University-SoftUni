package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String url = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputOne.txt";
        String url2 = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\inputTwo.txt";
        // Creating the file
        FileWriter file = new FileWriter("MergeTwoFiles.txt");
        // Merging the elements of the two files
        writeToFile(file, url);
        writeToFile(file, url2);
    }

    private static void writeToFile(FileWriter file, String url) throws IOException {
        // Reading all lines from the file (opening the input stream)
        Path path = Path.of(url);
        List<String> list = Files.readAllLines(path);
        // Writing all lines in the file (opening output stream & closing the input stream)
        BufferedWriter writer = new BufferedWriter(file);
        for (String line : list) {
            writer.write(line);
            writer.newLine();
        }
        // Closing output stream
        writer.flush();
    }
}
