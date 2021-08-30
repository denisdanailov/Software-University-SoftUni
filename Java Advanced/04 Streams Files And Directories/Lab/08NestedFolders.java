package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\Olegati\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(file);

        PrintStream out = new PrintStream("NestedFolders.txt");
        int foldersCount = 1;
        while (!queue.isEmpty()) {
            File currFile = queue.pop();
            out.println(currFile.getName());
            File[] nestedFiles = currFile.listFiles();
            for (File f : nestedFiles) {
                if (f.isDirectory()) {
                    foldersCount += 1;
                    queue.offer(f);
                }
                // Принтиране на всички файлове и директории
//                else {
//                    out.println(f.getName());
//                }
            }
        }
        out.printf("%d folders", foldersCount);
    }
}
