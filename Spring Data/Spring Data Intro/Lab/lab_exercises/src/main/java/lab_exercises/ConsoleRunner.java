package lab_exercises;

import lab_exercises.models.Account;
import lab_exercises.models.User;
import lab_exercises.services.AccountServiceImpl;
import lab_exercises.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void run(String... args) throws Exception {

//        User newUser = new User("Viktor", 35);
//
//        userService.registerUser(newUser);
//
//        Account newAccount = new Account(new BigDecimal(100000), newUser);
//
//        accountService.registerAccount(newAccount);

        accountService.depositMoney(new BigDecimal(-1), new Long("1"));

    }
}
