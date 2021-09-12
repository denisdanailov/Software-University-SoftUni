package IteratorsAndComparators.Lab.ComparableBook;

import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    // Constructor
    public Book(String title, int year, String... args) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(args);
    }

    // Setters
    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        this.authors = new ArrayList<>();
        for (int i = 0; i < authors.length; i++) {
            this.authors.add(authors[i]);
        }
    }

    // Getters
    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    // Compare To
    @Override
    public int compareTo(Book other) {
        if (this.getTitle().compareTo(other.getTitle()) > 0) {
            return 1;
        } else if (this.getTitle().compareTo(other.getTitle()) < 0) {
            return  -1;
        } else {
            if (this.getYear() > other.getYear()) {
                return 1;
            } else if (this.getYear() < other.getYear()) {
                return -1;
            }
            return 0;
        }
    }
}
