package lab_exercises.services;

import lab_exercises.models.Account;

import java.math.BigDecimal;

public interface AccountService {
    void registerAccount(Account account);
    void withdrawMoney(BigDecimal amount, Long id);
    void depositMoney(BigDecimal amount, Long id);
}
