package exams.javaOopExamApril2021.problem1.aquarium;

import exams.javaOopExamApril2021.problem1.aquarium.core.Engine;
import exams.javaOopExamApril2021.problem1.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
