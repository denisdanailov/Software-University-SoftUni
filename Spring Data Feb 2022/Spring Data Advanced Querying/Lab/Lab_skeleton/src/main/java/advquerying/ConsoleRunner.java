package advquerying;

import advquerying.entities.Ingredient;
import advquerying.entities.Shampoo;
import advquerying.entities.Size;
import advquerying.repositories.IngredientsRepository;
import advquerying.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private ShampooRepository shampooRepo;
    private IngredientsRepository ingredientsRepo;

    @Autowired
    public ConsoleRunner(ShampooRepository shampooRepo, IngredientsRepository ingredientsRepo) {
        this.shampooRepo = shampooRepo;
        this.ingredientsRepo = ingredientsRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scan = new Scanner(System.in);

//        _01_SelectShampoosBySize(scan);

//        _02_SelectShampoosBySizeOrLabel(scan);

//        _03_SelectShampoosByPrice(scan);

//        _04_SelectIngredientsByName(scan);

//        _05_SelectIngredientsByNames();

//        _06_CountShampoosByPrice(scan);

//        _07_SelectShampoosByIngredients();

//        _08_SelectShampoosByIngredientsCount(scan);

//        _09_DeleteIngredientsByName();

//        _10_UpdateIngredientsByPrice();

//        _11_UpdateIngredientsByNames();
    }

    private void _11_UpdateIngredientsByNames() {
        ingredientsRepo.increasePriceOfAllNameIn(new BigDecimal(1.1), List.of("Macadamia Oil", "Apple", "Herbs"));
    }

    private void _10_UpdateIngredientsByPrice() {
        ingredientsRepo.increasePriceOfAllBy(new BigDecimal(1.1));
    }

    private void _09_DeleteIngredientsByName(Scanner scan) {
        System.out.println("Please enter name of the ingredient to be deleted:");
        String nameParam = scan.nextLine();

        int affectedRows = ingredientsRepo.deleteByName(nameParam);

        System.out.println(affectedRows);
    }

    private void _08_SelectShampoosByIngredientsCount(Scanner scan) {
        System.out.println("Please enter number of ingredients:");

        long numIngredients = Long.parseLong(scan.nextLine());

        List<Shampoo> shampooList = shampooRepo.findAllByIngredientsLessThan(numIngredients);

        shampooList.forEach(s -> System.out.printf("%s%n",
                s.getBrand()));
    }

    private void _07_SelectShampoosByIngredients() {
        List<String> ingredientNames = Arrays.asList("Berry", "Mineral-Collagen");

        Set<Shampoo> shampooSet = shampooRepo.findAllByIngredientsNames(ingredientNames);

        shampooSet.forEach(s -> System.out.printf("%s%n",
                s.getBrand()));
    }

    private void _06_CountShampoosByPrice(Scanner scan) {
        System.out.println("Please enter price:");
        String inputPrice = scan.nextLine();

        int shampooCount = shampooRepo.countAllByPriceLessThan(new BigDecimal(inputPrice));

        System.out.println(shampooCount);
    }

    private void _05_SelectIngredientsByNames() {
        List<String> ingNamesList = Arrays.asList("Lavender", "Herbs", "Apple");

        List<Ingredient> ingredientList = ingredientsRepo.findAllByNameInOrderByPriceAsc(ingNamesList);

        ingredientList.forEach(i -> System.out.printf("%s%n",
                i.getName()));
    }

    private void _04_SelectIngredientsByName(Scanner scan) {
        System.out.println("Please enter the first character of the ingredient's name:");

        String startSymbol = scan.nextLine();

        List<Ingredient> ingredientList = ingredientsRepo.findAllByNameStartingWith(startSymbol);

        ingredientList.forEach(i -> System.out.printf("%s%n",
                i.getName()));
    }

    private void _03_SelectShampoosByPrice(Scanner scan) {
        System.out.println("Please enter price:");
        String inputPrice = scan.nextLine();

        BigDecimal price = new BigDecimal(inputPrice);

        List<Shampoo> shampooList = shampooRepo.findAllByPriceGreaterThanOrderByPriceDesc(price);

        shampooList.forEach(s -> System.out.printf("%s %s %slv.%n",
                s.getBrand(),
                s.getSize().name(),
                s.getPrice().toString()));
    }

    private void _02_SelectShampoosBySizeOrLabel(Scanner scan) {
        System.out.println("Please enter size [SMALL, MEDIUM, LARGE]");
        String inputSize = scan.nextLine();
        System.out.println("Please enter label id");
        String labelId = scan.nextLine();

        List<Shampoo> shampooList = shampooRepo.findAllBySizeOrLabelIdOrderByPriceAsc(Size.valueOf(inputSize), new Long(labelId));

        shampooList.forEach(s -> System.out.printf("%s %s %slv.%n",
                s.getBrand(),
                s.getSize().name(),
                s.getPrice().toString()));
    }

    private void _01_SelectShampoosBySize(Scanner scan) {
        System.out.println("Please enter size [SMALL, MEDIUM, LARGE]");
        String inputSize = scan.nextLine();
        List<Shampoo> shampooList = shampooRepo.findAllBySizeOrderById(Size.valueOf(inputSize));

        shampooList.forEach(s -> System.out.printf("%s %s %slv.%n",
                s.getBrand(),
                s.getSize().name(),
                s.getPrice().toString()));
    }
}
