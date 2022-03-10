package spring_data_intro_exercises.services;

import java.io.IOException;

public interface SeedServices {
    void seedBook() throws IOException;
    void seedAuthor() throws IOException;
    void seedCategory() throws IOException;

    void seedDatabase() throws IOException;
}
