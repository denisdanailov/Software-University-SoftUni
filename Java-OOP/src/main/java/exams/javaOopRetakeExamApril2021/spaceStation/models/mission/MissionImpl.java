package exams.javaOopRetakeExamApril2021.spaceStation.models.mission;

import exams.javaOopRetakeExamApril2021.spaceStation.models.astronauts.Astronaut;
import exams.javaOopRetakeExamApril2021.spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission{
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Collection<String> items = planet.getItems();
        for (Astronaut astronaut : astronauts) {
            if (astronaut.canBreath()) {
                while (items.iterator().hasNext() && astronaut.canBreath()) {
                    // Get next item
                    String item = items.iterator().next();
                    // Astronaut adds item in the bag
                    astronaut.getBag().getItems().add(item);
                    // Item is removed from planet
                    items.remove(item);
                    // Astronaut takes breath()
                    astronaut.breath();
                }
            }
        }

    }
}
