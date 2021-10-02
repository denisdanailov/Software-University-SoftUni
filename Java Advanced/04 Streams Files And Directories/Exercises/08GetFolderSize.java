package StreamsFilesAndDirectories.Exercises;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GetFolderSize {
    public static void main(String[] args) {
        // Reading the folder/ directory
        String url = "C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources";

        File folder = new File(url);
        File[] filesArray = folder.listFiles();

        long sumBytes = 0;
        for (int i = 0; i < filesArray.length; i++) {
            sumBytes += filesArray[i].length();
        }

        System.out.printf("Folder size: %d%n", sumBytes);
    }
}
