package spring_data_intro_exercises.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_data_intro_exercises.entities.Author;
import spring_data_intro_exercises.repositories.AuthorRepository;

import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepo;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author getRandomAuthor() {
        long count = authorRepo.count();

        int randIndex = new Random().nextInt((int)count) + 1;


        return this.authorRepo.findById(randIndex).get();
    }
}
