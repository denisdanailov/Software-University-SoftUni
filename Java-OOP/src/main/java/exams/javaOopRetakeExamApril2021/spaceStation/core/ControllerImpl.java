package exams.javaOopRetakeExamApril2021.spaceStation.core;

import exams.javaOopRetakeExamApril2021.spaceStation.common.ConstantMessages;
import exams.javaOopRetakeExamApril2021.spaceStation.common.ExceptionMessages;
import exams.javaOopRetakeExamApril2021.spaceStation.models.astronauts.Astronaut;
import exams.javaOopRetakeExamApril2021.spaceStation.models.astronauts.Biologist;
import exams.javaOopRetakeExamApril2021.spaceStation.models.astronauts.Geodesist;
import exams.javaOopRetakeExamApril2021.spaceStation.models.astronauts.Meteorologist;
import exams.javaOopRetakeExamApril2021.spaceStation.models.mission.Mission;
import exams.javaOopRetakeExamApril2021.spaceStation.models.mission.MissionImpl;
import exams.javaOopRetakeExamApril2021.spaceStation.models.planets.Planet;
import exams.javaOopRetakeExamApril2021.spaceStation.models.planets.PlanetImpl;
import exams.javaOopRetakeExamApril2021.spaceStation.repositories.AstronautRepository;
import exams.javaOopRetakeExamApril2021.spaceStation.repositories.PlanetRepository;

import java.util.ArrayList;
import java.util.Collection;

import static exams.javaOopRetakeExamApril2021.spaceStation.common.ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER;
import static exams.javaOopRetakeExamApril2021.spaceStation.common.ConstantMessages.REPORT_PLANET_EXPLORED;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private int countExploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.countExploredPlanets = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut = null;

        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

        this.astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        for (String element : items) {
            planet.getItems().add(element);
        }

        this.planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut retiredAstronaut = this.astronautRepository.findByName(astronautName);
        if(retiredAstronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        this.astronautRepository.remove(retiredAstronaut);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Mission mission = new MissionImpl();
        // Create planet
        Planet planet = this.planetRepository.findByName(planetName);
        // Choose Astronauts
        Collection<Astronaut> astronauts = new ArrayList<>();
        for (Astronaut astronaut : this.astronautRepository.getModels()) {
          if (astronaut.getOxygen() > 60) {
              astronauts.add(astronaut);
          }
        }

        if (astronauts.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        // Send astronauts on a mission
        mission.explore(planet,astronauts);
        countExploredPlanets++;
        long count = astronauts.stream().filter(e -> e.getOxygen() == 0).count();
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, count);
    }

    @Override
    public String report() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(String.format(REPORT_PLANET_EXPLORED,countExploredPlanets)).append(System.lineSeparator());
        strBuild.append(ConstantMessages.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut astronaut : this.astronautRepository.getModels()) {
            strBuild.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME,astronaut.getName())).append(System.lineSeparator());
            strBuild.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN,astronaut.getOxygen())).append(System.lineSeparator());
            Collection<String> items = astronaut.getBag().getItems();
            if (items.isEmpty()) {
                strBuild.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none")).append(System.lineSeparator());
            } else {
                strBuild.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, items))).append(System.lineSeparator());
            }
        }
        return strBuild.toString().trim();
    }
}
