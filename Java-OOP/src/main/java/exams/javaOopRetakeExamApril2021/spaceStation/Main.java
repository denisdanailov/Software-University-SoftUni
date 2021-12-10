package exams.javaOopRetakeExamApril2021.spaceStation;

import exams.javaOopRetakeExamApril2021.spaceStation.core.Controller;
import exams.javaOopRetakeExamApril2021.spaceStation.core.ControllerImpl;
import exams.javaOopRetakeExamApril2021.spaceStation.core.Engine;
import exams.javaOopRetakeExamApril2021.spaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
