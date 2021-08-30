package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class ListFiles {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File newFile = new File(path);

        File[] fileArr = newFile.listFiles();
        PrintWriter out = new PrintWriter("ListFiles.txt");

        Arrays.stream(fileArr).forEach(file -> {
            if (!file.isDirectory()) {
                out.printf("%s: [%d]%n", file.getName(), file.length());
            }
        });

        out.flush();
        out.close();
    }
}
