package DefiningClasses.Lab.BankAccount;

public class BankAccount {
    // Id Count
    private static int id = 0;

    BankAccount() {
        id++;
    }

    public static int getId() {
        return id;
    }
    // Balance
    private double balance;

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double amount) {
        this.balance += amount;
    }
    // Interest Rate
    private static double interestRate = 0.02;

    public static void setInterestRate(double newInterestRate) {
        interestRate = newInterestRate;
    }

    public double getInterest(int years) {
        return years * (balance * interestRate);
    }
}
