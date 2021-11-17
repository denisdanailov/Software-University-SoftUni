package solidPrinciples.exercises.logger.file;

import solidPrinciples.exercises.logger.interfaces.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogFile implements File {

    private final static String DEFAULT_FILE_NAME = "default.txt";

    private StringBuilder strBuild;
    private int size;
    private String fileName;

    public LogFile(String name) {
        this.size = 0;
        this.strBuild = new StringBuilder();
        this.fileName = name;
    }

    public LogFile () {
        this(DEFAULT_FILE_NAME);
    }

    @Override
    public int getSize() {
        return calculateSize();
    }

    private int calculateSize() {
        int size = 0;
        for (int i = 0; i < strBuild.length(); i++) {
            char c = strBuild.charAt(i);
            if (Character.isAlphabetic(c)) {
                size += c;
            }
        }
        return size;
    }

    @Override
    public boolean write(String text) {
        try {
            Files.write(Paths.get(this.fileName), text.getBytes(), StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void append(String text) {
        text = addLineBreakInFile(text);
        this.strBuild.append(text);
        this.write(text);
    }

    String addLineBreakInFile(String text) {
        StringBuilder sb = new StringBuilder(text);
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
