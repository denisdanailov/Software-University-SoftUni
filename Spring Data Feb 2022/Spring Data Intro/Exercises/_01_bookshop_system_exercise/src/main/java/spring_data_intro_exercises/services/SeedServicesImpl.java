package spring_data_intro_exercises.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_data_intro_exercises.enums.AgeRestriction;
import spring_data_intro_exercises.enums.EditionType;
import spring_data_intro_exercises.entities.Author;
import spring_data_intro_exercises.entities.Book;
import spring_data_intro_exercises.entities.Category;
import spring_data_intro_exercises.repositories.AuthorRepository;
import spring_data_intro_exercises.repositories.BookRepository;
import spring_data_intro_exercises.repositories.CategoryRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedServicesImpl implements SeedServices{

    private static final String RESOURCE_PATH = "src\\main\\resources\\files\\";
    private static final String BOOKS_FILE_NAME = "books.txt";
    private static final String AUTHORS_FILE_NAME = "authors.txt";
    private static final String CATEGORIES_FILE_NAME = "categories.txt";

    private BookRepository bookRepo;
    private AuthorRepository authorRepo;
    private CategoryRepository categoryRepo;

    private AuthorService authorService;
    private CategoryService categoryService;

    @Autowired
    public SeedServicesImpl(BookRepository bookRepo, AuthorRepository authorRepo, CategoryRepository categoryRepo,
                            AuthorService authorService, CategoryService categoryService) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.categoryRepo = categoryRepo;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @Override
    public void seedBook() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_PATH + BOOKS_FILE_NAME))
        .forEach( row -> {
            String[] data = row.split("\\s+");

            Author author = authorService.getRandomAuthor();
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            LocalDate releaseDate = LocalDate.parse(data[1],
                    DateTimeFormatter.ofPattern("d/M/yyyy"));
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction
                    .values()[Integer.parseInt(data[4])];
            String title = Arrays.stream(data)
                    .skip(5)
                    .collect(Collectors.joining(" "));
            Set<Category> categories = categoryService.getRandomCategories();


            Book book = new Book(title, editionType, price, copies, releaseDate, ageRestriction, author,categories);

            bookRepo.save(book);
        });
    }

    @Override
    public void seedAuthor() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_PATH + AUTHORS_FILE_NAME))
                .forEach( row -> {

                    String firstName = row.split("\\s+")[0];
                    String lastName = row.split("\\s+")[1];

                    Author author = new Author(firstName, lastName);

                    authorRepo.save(author);
                });
    }

    @Override
    public void seedCategory() throws IOException {
        Files.readAllLines(Path.of(RESOURCE_PATH + CATEGORIES_FILE_NAME))
                .forEach(row -> {
                    if(row.trim().equals("")) {
                        return;
                    }
                    Category category = new Category(row);

                    categoryRepo.save(category);
                });
    }

    @Override
    public void seedDatabase() throws IOException {
        seedAuthor();
        seedCategory();
        seedBook();
    }
}
