package exams.javaOopRetakeExamAugust2021.glacialExpedition.models.states;

import exams.javaOopRetakeExamAugust2021.glacialExpedition.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StateImpl implements State {
    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name) {
        setName(name);
        exhibits = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.STATE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return name;
    }
}
