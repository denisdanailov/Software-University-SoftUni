package exams.javaOopExamAugust2021.restaurant.core;

import exams.javaOopExamAugust2021.restaurant.common.ExceptionMessages;
import exams.javaOopExamAugust2021.restaurant.common.OutputMessages;
import exams.javaOopExamAugust2021.restaurant.core.interfaces.Controller;
import exams.javaOopExamAugust2021.restaurant.repositories.interfaces.BeverageRepository;
import exams.javaOopExamAugust2021.restaurant.repositories.interfaces.HealthFoodRepository;
import exams.javaOopExamAugust2021.restaurant.repositories.interfaces.TableRepository;
import exams.javaOopExamAugust2021.restaurant.entities.drinks.Fresh;
import exams.javaOopExamAugust2021.restaurant.entities.drinks.Smoothie;
import exams.javaOopExamAugust2021.restaurant.entities.healthyFoods.Salad;
import exams.javaOopExamAugust2021.restaurant.entities.healthyFoods.VeganBiscuits;
import exams.javaOopExamAugust2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import exams.javaOopExamAugust2021.restaurant.entities.drinks.interfaces.Beverages;
import exams.javaOopExamAugust2021.restaurant.entities.tables.InGarden;
import exams.javaOopExamAugust2021.restaurant.entities.tables.Indoors;
import exams.javaOopExamAugust2021.restaurant.entities.tables.interfaces.Table;


import static exams.javaOopExamAugust2021.restaurant.common.ExceptionMessages.BEVERAGE_EXIST;
import static exams.javaOopExamAugust2021.restaurant.common.ExceptionMessages.TABLE_IS_ALREADY_ADDED;
import static exams.javaOopExamAugust2021.restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalProfit;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food = type.equals("Salad")
                ? new Salad(name, price)
                : new VeganBiscuits(name, price);

        HealthyFood foodFromRepo = healthFoodRepository.foodByName(name);
        if (foodFromRepo != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
        }
        healthFoodRepository.add(food);
        return String.format(OutputMessages.FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage = type.equals("Smoothie")
                ? new Smoothie(name, counter, brand)
                : new Fresh(name, counter, brand);

        Beverages drinkFromRepo = beverageRepository.beverageByName(name, brand);
        if (drinkFromRepo != null) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }
        beverageRepository.add(beverage);
        return String.format(BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = type.equals("Indoors")
                ? new Indoors(tableNumber, capacity)
                : new InGarden(tableNumber, capacity);

        Table tableFromRepo = tableRepository.byNumber(tableNumber);
        if (tableFromRepo != null) {
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, tableNumber));
        }
        tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        for (Table table : tableRepository.getAllEntities()) {
            boolean isReserved = table.isReservedTable();
            int tableSize = table.getSize();
            if (!isReserved && numberOfPeople <= tableSize) {
                table.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
            }
        }
        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        HealthyFood foodInMenu = healthFoodRepository.foodByName(healthyFoodName);
        if (foodInMenu == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }
        table.orderHealthy(foodInMenu);
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        Beverages beverageInMenu = beverageRepository.beverageByName(name, brand);
        if (beverageInMenu == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }
        table.orderBeverages(beverageInMenu);
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);
        double bill = table.bill();
        totalProfit += bill;
        table.clear();
        return String.format(BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, totalProfit);
    }
}
