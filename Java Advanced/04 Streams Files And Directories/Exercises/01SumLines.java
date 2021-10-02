package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String localPath = "C:\\Users\\Olegati\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\input.txt";

        Path path = Path.of(localPath);
        List<String> list = Files.readAllLines(path);
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            for (int j = 0; j <list.get(i).length(); j++) {
                sum += list.get(i).charAt(j);
            }
            System.out.println(sum);
        }
    }
}
