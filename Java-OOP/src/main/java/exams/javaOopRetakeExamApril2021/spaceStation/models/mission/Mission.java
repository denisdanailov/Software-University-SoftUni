package exams.javaOopRetakeExamApril2021.spaceStation.models.mission;

import exams.javaOopRetakeExamApril2021.spaceStation.models.astronauts.Astronaut;
import exams.javaOopRetakeExamApril2021.spaceStation.models.planets.Planet;

import java.util.Collection;

public interface Mission {
    void explore(Planet planet, Collection<Astronaut> astronauts);
}
