package com.example.cardealer;

import com.example.cardealer.services.SeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private SeedingService seedingService;

    @Autowired
    public ConsoleRunner(SeedingService seedingService) {
        this.seedingService = seedingService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.seedingService.seedSuppliers();
    }
}
