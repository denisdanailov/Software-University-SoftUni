package exams.javaOopRetakeExamAugust2021.glacialExpedition.core;

import exams.javaOopRetakeExamAugust2021.glacialExpedition.common.Command;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.common.ConstantMessages;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.common.ExceptionMessages;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.explorers.AnimalExplorer;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.explorers.Explorer;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.explorers.GlacierExplorer;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.explorers.NaturalExplorer;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.mission.Mission;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.mission.MissionImpl;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.states.State;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.models.states.StateImpl;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.repositories.ExplorerRepository;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.repositories.Repository;
import exams.javaOopRetakeExamAugust2021.glacialExpedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.Collection;;

import static exams.javaOopRetakeExamAugust2021.glacialExpedition.common.ConstantMessages.*;
import static exams.javaOopRetakeExamAugust2021.glacialExpedition.common.ExceptionMessages.EXPLORER_DOES_NOT_EXIST;

public class ControllerImpl implements Controller {
    private Repository<Explorer> explorerRepo = new ExplorerRepository();
    private Repository<State> stateRepo = new StateRepository();
    private int countExploredStates = 0;

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;

        switch (type) {
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }

        explorerRepo.add(explorer);
        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State newState = new StateImpl(stateName);

        Collection<String> newStateExhibits = newState.getExhibits();

        for (String exhibit : exhibits) {
            newStateExhibits.add(exhibit);
        }

        stateRepo.add(newState);

        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer retiredExplorer = explorerRepo.byName(explorerName);
        if (retiredExplorer == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        explorerRepo.remove(retiredExplorer);
        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        Mission mission = new MissionImpl();

        State state = stateRepo.byName(stateName);
        if (state == null) {
            throw new IllegalArgumentException("State doesn't exist in StateRepository");
        }

        Collection<Explorer> explorers = new ArrayList<>();
        for (Explorer explorer : explorerRepo.getCollection()) {
            if (explorer.getEnergy() > 50) {
                explorers.add(explorer);
            }
        }

        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        mission.explore(state, explorers);

        long countRetiredExplorers = explorers.stream().filter(e -> e.getEnergy() == 0).count();
        countExploredStates++;

        return String.format(ConstantMessages.STATE_EXPLORER, stateName, countRetiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(String.format(FINAL_STATE_EXPLORED, countExploredStates)).append(System.lineSeparator());
        strBuild.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());
        for (Explorer explorer : explorerRepo.getCollection()) {
            strBuild.append(String.format(FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            strBuild.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());

            Collection<String> exhibits = explorer.getSuitcase().getExhibits();
            if (exhibits.isEmpty()) {
                strBuild.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"))
                        .append(System.lineSeparator());
            } else {
                strBuild.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, exhibits)))
                        .append(System.lineSeparator());
            }
        }
        return strBuild.toString().trim();
    }
}
