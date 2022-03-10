package spring_data_intro_exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_data_intro_exercises.entities.Author;
import spring_data_intro_exercises.entities.Book;
import spring_data_intro_exercises.repositories.AuthorRepository;
import spring_data_intro_exercises.repositories.BookRepository;
import spring_data_intro_exercises.services.SeedServices;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private SeedServices seedServices;
    private BookRepository bookRepo;
    private AuthorRepository authorRepo;

    @Autowired
    public ConsoleRunner(SeedServices seedServices, BookRepository bookRepo, AuthorRepository authorRepo) {
        this.seedServices = seedServices;
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        seedServices.seedDatabase();

        _01_findAllBooksAfter2000();

        _02_findAllAuthorsWithBooksBefore1990();

        _03_findAllAuthorsSortByBooksCountDesc();

        _04_findAllBooksByAuthorFirstAndLastNameOrdered();
    }

    private void _04_findAllBooksByAuthorFirstAndLastNameOrdered() {
        List<Book> listBooks = bookRepo.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell");

        listBooks.forEach(b -> System.out.printf("%s %s -> Number of copies: %d%n",
                b.getTitle(),
                b.getReleaseDate().toString(),
                b.getCopies()));
    }

    private void _03_findAllAuthorsSortByBooksCountDesc() {
        List<Author> allAuthors = authorRepo.findAllDistinctByBooksNotNull();

        allAuthors.stream()
                .sorted((a1, a2) -> Integer.compare(a2.getBooks().size(), a1.getBooks().size()))
                .forEach(a -> System.out.printf("%s %s: Book count %d%n",
                        a.getFirstName(),
                        a.getLastName(),
                        a.getBooks().size()));
    }

    private void _02_findAllAuthorsWithBooksBefore1990() {
        List<Author> authorsList = authorRepo.findAllDistinctByBooksReleaseDateBefore(LocalDate.of(1990, 01, 01));

        authorsList.forEach(a -> System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));
    }

    private void _01_findAllBooksAfter2000() {
        List<Book> booksList = bookRepo.findAllByReleaseDateAfter(LocalDate.of(2000, 12, 31));

        booksList.forEach(b -> System.out.printf("%s %s%n",
                b.getReleaseDate().format(DateTimeFormatter.ISO_LOCAL_DATE),
                b.getTitle()));
    }
}
