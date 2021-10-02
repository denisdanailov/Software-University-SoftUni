package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        // Reading from a file
        String localPath = "C:\\Users\\Olegati\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\input.txt";

        Path path = Path.of(localPath);
        List<String> list = Files.readAllLines(path);
        // Logic
        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuation = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                char nextChar = list.get(i).charAt(j);
                if (nextChar != ' ' && nextChar != '?' && nextChar != '.'
                        && nextChar != '!' && nextChar != ',') {
                    switch (nextChar) {
                        case 'a':
                        case 'o':
                        case 'u':
                        case 'e':
                        case 'i':
                            countVowels++;
                            break;
                        default:
                            countConsonants++;
                            break;
                    }
                } else {
                    switch (nextChar) {
                        case '?':
                        case '.':
                        case ',':
                        case '!':
                            countPunctuation++;
                            break;
                    }
                }
            }
        }
        // Writing in a file (opening the output stream)
        BufferedWriter writer = new BufferedWriter(new FileWriter("CountCharacterTypes.txt"));
        writer.write(String.format("Vowels: %d", countVowels));
        writer.newLine();
        writer.write(String.format("Consonants: %d", countConsonants));
        writer.newLine();
        writer.write(String.format("Punctuation: %d", countPunctuation));
        // closing the output stream
        writer.close();
    }
}
