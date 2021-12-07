package exams.javaOopExamAugust2021.restaurant;

import exams.javaOopExamAugust2021.restaurant.core.ControllerImpl;
import exams.javaOopExamAugust2021.restaurant.core.EngineImpl;
import exams.javaOopExamAugust2021.restaurant.core.interfaces.Controller;
import exams.javaOopExamAugust2021.restaurant.entities.drinks.interfaces.Beverages;
import exams.javaOopExamAugust2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import exams.javaOopExamAugust2021.restaurant.entities.tables.InGarden;
import exams.javaOopExamAugust2021.restaurant.entities.tables.interfaces.Table;

import exams.javaOopExamAugust2021.restaurant.io.ConsoleReader;
import exams.javaOopExamAugust2021.restaurant.io.ConsoleWriter;
import exams.javaOopExamAugust2021.restaurant.repositories.BeverageRepositoryImpl;
import exams.javaOopExamAugust2021.restaurant.repositories.HealthFoodRepositoryImpl;
import exams.javaOopExamAugust2021.restaurant.repositories.TableRepositoryImpl;
import exams.javaOopExamAugust2021.restaurant.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {

        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();


        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }
}
