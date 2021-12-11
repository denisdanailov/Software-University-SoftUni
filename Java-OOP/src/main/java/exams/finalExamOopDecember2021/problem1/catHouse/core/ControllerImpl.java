package exams.finalExamOopDecember2021.problem1.catHouse.core;

import exams.finalExamOopDecember2021.problem1.catHouse.common.ConstantMessages;
import exams.finalExamOopDecember2021.problem1.catHouse.common.ExceptionMessages;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.cat.Cat;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.cat.LonghairCat;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.cat.ShorthairCat;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.houses.House;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.houses.LongHouse;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.houses.ShortHouse;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.toys.Ball;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.toys.Mouse;
import exams.finalExamOopDecember2021.problem1.catHouse.entities.toys.Toy;
import exams.finalExamOopDecember2021.problem1.catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house = null;

        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }

        this.houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;

        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }

        this.toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }

        for (House house : this.houses) {
            if (house.getName().equals(houseName)) {
                house.buyToy(toy);
                toys.removeToy(toy);
            }
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat = null;

        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }



        for (House house : this.houses) {
            if (house.getName().equals(houseName)) {
                if (house.getClass().getSimpleName().contains("Short") && catType.contains("Long") ||
                        house.getClass().getSimpleName().contains("Long") && catType.contains("Short")) {
                    return ConstantMessages.UNSUITABLE_HOUSE;
                }
                house.addCat(cat);
                return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
            }
        }

        return "No house with such a name was found.";
    }

    @Override
    public String feedingCat(String houseName) {

        for (House house : this.houses) {
            if (house.getName().equals(houseName)) {
                house.feeding();
                long countFedCats = house.getCats().stream().count();
                return String.format(ConstantMessages.FEEDING_CAT, countFedCats);
            }
        }

        return "No house with such a name was found.";
    }

    @Override
    public String sumOfAll(String houseName) {
        for (House house : this.houses) {
            if (house.getName().equals(houseName)) {
                double sumCatsPrice = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
                double sumToysPrice = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
                return String.format(ConstantMessages.VALUE_HOUSE, houseName, sumCatsPrice + sumToysPrice);
            }
        }

        return "No house with such a name was found.";
    }

    @Override
    public String getStatistics() {
        StringBuilder strBuild = new StringBuilder();

        for (House house : this.houses) {
            strBuild.append(house.getStatistics()).append(System.lineSeparator());
        }

        return strBuild.toString().trim();
    }
}
