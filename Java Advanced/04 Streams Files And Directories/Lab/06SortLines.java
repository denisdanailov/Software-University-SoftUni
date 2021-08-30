package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SortLines {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String path = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        PrintStream out = new PrintStream("SortLines.txt");

        ArrayList<String> list = new ArrayList<>();
        String nextLine = bufferedReader.readLine();
        while ( nextLine != null) {
            list.add(nextLine);
            nextLine = bufferedReader.readLine();
        }

        Collections.sort(list);

        list.stream().forEach(out::println);
    }
}
