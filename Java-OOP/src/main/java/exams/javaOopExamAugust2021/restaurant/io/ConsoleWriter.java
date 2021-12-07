package exams.javaOopExamAugust2021.restaurant.io;

import exams.javaOopExamAugust2021.restaurant.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
