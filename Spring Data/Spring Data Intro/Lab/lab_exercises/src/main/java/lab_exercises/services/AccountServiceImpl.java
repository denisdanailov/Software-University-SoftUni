package lab_exercises.services;

import lab_exercises.models.Account;
import lab_exercises.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accRepo;

    @Autowired
    public AccountServiceImpl(AccountRepository accRepo) {
        this.accRepo = accRepo;
    }

    @Override
    public void registerAccount(Account account) {
        accRepo.save(account);
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) {
        Optional<Account> accOptional = accRepo.findById(id);

        if (accOptional.isEmpty()) {
            return;
        }

        Account account = accOptional.get();

        if (account.getUser() == null) {
            return;
        }

        BigDecimal accBalance = account.getBalance();
        if (accBalance.compareTo(amount) < 0) {
            return;
        }

        BigDecimal newAccBalance = accBalance.subtract(amount);

        account.setBalance(newAccBalance);

        accRepo.save(account);
    }

    @Override
    public void depositMoney(BigDecimal amount, Long id) {
        Optional<Account> accOptional = accRepo.findById(id);

        if (accOptional.isEmpty()) {
            return;
        }

        Account account = accOptional.get();

        if (account.getUser() == null) {
            return;
        }

        if (amount.doubleValue() <= 0) {
          return;
        }

        BigDecimal accBalance = account.getBalance();

        BigDecimal newAccBalance = accBalance.add(amount);

        account.setBalance(newAccBalance);

        accRepo.save(account);
    }
}
