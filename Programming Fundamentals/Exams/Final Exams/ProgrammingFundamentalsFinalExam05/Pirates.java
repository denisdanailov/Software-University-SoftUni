package Exams.FinalExams.ProgrammingFundamentalsFinalExam05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pirates {

    public static class Cities {
    String cityName;
    int population;
    int gold;
    public Cities(String cityName, int population, int gold) {
        this.cityName = cityName;
        this.population = population;
        this.gold = gold;
    }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        List<Cities> targetCities = new ArrayList<>();
        while (!input.equals("Sail")) {
            String[] tokens = input.split("\\|{2}");
            String cityName = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            Cities newCity = new Cities(cityName, population, gold);
            if (cityDoesExist(targetCities,cityName) == -1) {
                targetCities.add(newCity);
            } else {
                int index = cityDoesExist(targetCities, cityName);
                targetCities.get(index).gold += gold;
                targetCities.get(index).population += population;
            }
            input = scan.nextLine();
        }

        input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("=>");
            String action = tokens[0];
            switch (action) {
                case"Plunder":
                    String town = tokens[1];
                    int people = Integer.parseInt(tokens[2]);
                    int gold = Integer.parseInt(tokens[3]);
                    int cityIndex = cityDoesExist(targetCities, town);
                    targetCities.get(cityIndex).population -= people;
                    targetCities.get(cityIndex).gold -= gold;
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                    if (targetCities.get(cityIndex).population == 0 || targetCities.get(cityIndex).gold == 0) {
                        targetCities.remove(cityIndex);
                        System.out.println(town + " has been wiped off the map!");
                    }
                    break;
                case"Prosper":
                    String city = tokens[1];
                    int money = Integer.parseInt(tokens[2]);
                    if (money < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int index = cityDoesExist(targetCities,city);
                        targetCities.get(index).gold += money;
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", money, city, targetCities.get(index).gold);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        if (targetCities.size() == 0) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", targetCities.size());
            targetCities.stream()
                    .sorted((a,b) ->  {
                        if (a.gold == b.gold) {
                            return a.cityName.compareTo(b.cityName);
                        } else {
                            return Integer.compare(b.gold,a.gold);
                        }
                    })
                    .forEach(city -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", city.cityName, city.population, city.gold));
        }
    }

    public static int cityDoesExist (List<Cities> cityList, String cityName) {
        int indexCity = -1;
        for (int i = 0; i < cityList.size(); i++) {
            String city = cityList.get(i).cityName;
            if (city.equals(cityName)) {
                indexCity = i;
                break;
            }
        }
        return indexCity;
    }
}
