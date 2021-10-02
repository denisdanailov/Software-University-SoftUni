package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        // Reading a file
        String url = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\words.txt";
        Path path = Path.of(url);
        List<String> list = Files.readAllLines(path);
        // Creating and updating map from file 1
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String[] strArr = list.get(i).split("\\s+");
            fillAndUpdateMap(map, strArr);
        }
        // Reading file 2
        String url2 = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\text.txt";
        Path path2 = Path.of(url2);
        List<String> list2 = Files.readAllLines(path2);
        // Updating files
        for (int i = 0; i < list2.size(); i++) {
            String[] strArr = list2.get(i).split("\\s+");
            updateMap(map, strArr);
        }
        // Writing to an output file (opening an output stream)
        BufferedWriter writer = new BufferedWriter(new FileWriter("WordCount.text"));
        map.entrySet().forEach(entry -> {
            try {
                writer.write(String.format("%s - %d",entry.getKey(), entry.getValue()));
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error printing on the file");
            }
        });
        // Closing the output stream
        writer.close();
    }

    private static void updateMap(Map<String, Integer> map, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            String nextString = strArr[i];
            if (map.containsKey(nextString)) {
                int currentValue = map.get(nextString);
                map.replace(nextString, currentValue + 1);
            }
        }
    }

    private static void fillAndUpdateMap(Map<String, Integer> map, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            String nextString = strArr[i];
            if (map.containsKey(nextString)) {
                int currentValue = map.get(nextString);
                map.replace(nextString, currentValue + 1);
            } else {
                map.put(nextString, 0);
            }
        }
    }
}
