package exams.javaOopExamApril2021.problem1.aquarium.core;

import exams.javaOopExamApril2021.problem1.aquarium.common.ConstantMessages;
import exams.javaOopExamApril2021.problem1.aquarium.common.ExceptionMessages;
import exams.javaOopExamApril2021.problem1.aquarium.entities.aquariums.Aquarium;
import exams.javaOopExamApril2021.problem1.aquarium.entities.aquariums.FreshwaterAquarium;
import exams.javaOopExamApril2021.problem1.aquarium.entities.aquariums.SaltwaterAquarium;
import exams.javaOopExamApril2021.problem1.aquarium.entities.decorations.Decoration;
import exams.javaOopExamApril2021.problem1.aquarium.entities.decorations.Ornament;
import exams.javaOopExamApril2021.problem1.aquarium.entities.decorations.Plant;
import exams.javaOopExamApril2021.problem1.aquarium.entities.fish.Fish;
import exams.javaOopExamApril2021.problem1.aquarium.entities.fish.FreshwaterFish;
import exams.javaOopExamApril2021.problem1.aquarium.entities.fish.SaltwaterFish;
import exams.javaOopExamApril2021.problem1.aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private List<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium = null;

        switch(aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }

        this.aquariums.add(aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration = null;

        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }

        this.decorations.add(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorations.findByType(decorationType);

        if (decoration == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }

        for (Aquarium aquarium : this.aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                aquarium.addDecoration(decoration);
            }
        }

        decorations.remove(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish = null;

        switch(fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }

        for (Aquarium aquarium : this.aquariums) {
            if (aquarium.getName().equals(aquariumName)) {

                if (fishType.contains("Freshwater") && !aquarium.getClass().getSimpleName().contains("Freshwater")
                        || fishType.contains("Saltwater") && !aquarium.getClass().getSimpleName().contains("Saltwater")) {

                    return ConstantMessages.WATER_NOT_SUITABLE;
                }

                try {
                    aquarium.addFish(fish);
                } catch (IllegalStateException e) {
                    return e.getMessage();
                }
            }
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        int countFed = 0;

        for (Aquarium aquarium : this.aquariums) {
            if (aquarium.getName().equals(aquariumName)) {

                aquarium.feed();

                countFed = aquarium.getFish().size();
            }
        }

        return String.format(ConstantMessages.FISH_FED, countFed);
    }

    @Override
    public String calculateValue(String aquariumName) {
        double sumDecorations = 0;
        double sumFish = 0;

        for (Aquarium aquarium : this.aquariums) {
            if (aquarium.getName().equals(aquariumName)) {

                sumDecorations = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
                sumFish = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
            }
        }

        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, sumDecorations + sumFish);
    }

    @Override
    public String report() {
        StringBuilder strBuild = new StringBuilder();
        for (Aquarium aquarium : this.aquariums) {
          strBuild.append(aquarium.getInfo())
          .append(System.lineSeparator());
        }

        return strBuild.toString().trim();
    }
}
