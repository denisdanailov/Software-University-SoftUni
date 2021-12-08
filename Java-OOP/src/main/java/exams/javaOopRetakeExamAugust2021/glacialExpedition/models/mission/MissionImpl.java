package exams.javaOopRetakeExamAugust2021.glacialExpedition.models.mission;

import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.explorers.Explorer;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.states.State;

import java.util.Collection;

public class MissionImpl implements Mission{

    @Override
    public void explore(State state, Collection<Explorer> explorers) {

        Collection<String> exhibits = state.getExhibits();

        for (Explorer explorer : explorers) {
            // Checks if the explorer has energy to search and there are more exhibits in the state to be found
            while (explorer.canSearch() && exhibits.iterator().hasNext()) {
                Collection<String> carton = explorer.getSuitcase().getExhibits();
                //Energy decreased
                explorer.search();
                // Exhibit found and added to the carton
                String nextExhibit = exhibits.iterator().next();
                carton.add(nextExhibit);

                exhibits.remove(nextExhibit);
            }
        }

    }
}
