package exams.javaOopRetakeExamAugust2021.glacialExpedition.models.mission;

import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.explorers.Explorer;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.states.State;


import java.util.Collection;

public interface Mission {
    void explore(State state, Collection<Explorer> explorers);
}
