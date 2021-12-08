package exams.javaOopRetakeExamAugust2021.glacialExpedition;

import exams.javaOopRetakeExamAugust2021.glacialExpedition.core.Controller;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.core.ControllerImpl;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.core.Engine;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
        System.out.println("");
    }
}
