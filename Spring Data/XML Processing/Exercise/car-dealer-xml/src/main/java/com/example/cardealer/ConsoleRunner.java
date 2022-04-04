package com.example.cardealer;

import com.example.cardealer.services.SeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final SeedingService seedingService;

    @Autowired
    public ConsoleRunner(SeedingService seedingService) {
        this.seedingService = seedingService;
    }

    @Override
    public void run(String... args) throws Exception {

//        _03_CarDealerImport();
    }

    private void _03_CarDealerImport() throws JAXBException {
        this.seedingService.seedAll();
    }
}
