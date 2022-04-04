package com.example.gamestore;

import com.example.gamestore.exceptions.ValidationException;
import com.example.gamestore.services.gameservice.GameExecuteService;
import com.example.gamestore.services.userservice.UserExecuteService;
import com.example.gamestore.services.viewservice.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private UserExecuteService userExecuteService;
    private GameExecuteService gameExecuteService;
    private ViewService viewService;

    @Autowired
    public ConsoleRunner(UserExecuteService userExecuteService, GameExecuteService gameExecuteService, ViewService viewService) {
        this.userExecuteService = userExecuteService;
        this.gameExecuteService = gameExecuteService;
        this.viewService = viewService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scan = new Scanner(System.in);

//        _02_ImplementUserRegistrationLoginAndLogout(scan);

//        _03_ImplementManagingGames(scan);

        _04_ImplementViewGames(scan);
    }

    private void _04_ImplementViewGames(Scanner scan) {
        String commandLine = scan.nextLine();

        String result = viewService.execute(commandLine);

        System.out.println(result);
    }

    private void _03_ImplementManagingGames(Scanner scan) {
        StringBuilder sb = new StringBuilder();

        String commandLine = scan.nextLine();

        while (!commandLine.equals("End")) {
            String result;
            try {
                result = gameExecuteService.execute(commandLine);
            } catch (ValidationException ex) {
                result = ex.getMessage();
            }

            sb.append(result).append(System.lineSeparator());

            commandLine = scan.nextLine();
        }

        System.out.println(sb.toString());
    }

    private void _02_ImplementUserRegistrationLoginAndLogout(Scanner scan) {
        StringBuilder sb = new StringBuilder();

        String commandLine = scan.nextLine();

        while (!commandLine.equals("End")) {
            String result;
            try {
                result = userExecuteService.execute(commandLine);
            } catch (ValidationException exception) {
                result = exception.getMessage();
            }

            sb.append(result).append(System.lineSeparator());

            commandLine = scan.nextLine();
        }

        System.out.println(sb.toString());
    }
}
