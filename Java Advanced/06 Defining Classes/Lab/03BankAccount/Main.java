package DefiningClasses.Lab.BankAccount;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<Integer, BankAccount> accountsMap = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String action = tokens[0];
            switch (action) {
                case "Create":
                    BankAccount newAccount = new BankAccount();
                    int currIdCount = BankAccount.getId();
                    accountsMap.put(currIdCount, newAccount);
                    System.out.println("Account ID" + currIdCount +" created");
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if (isIdValid(accountsMap, id)) {
                        accountsMap.get(id).setBalance(amount);
                        System.out.println("Deposited " + amount + " to ID" + id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int _id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (isIdValid(accountsMap, _id)) {
                        double interestRate = accountsMap.get(_id).getInterest(years);
                        System.out.printf("%.2f%n",interestRate);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scan.nextLine();
        }

    }

    public static boolean isIdValid(Map<Integer,BankAccount> map, int id) {
        if (map.containsKey(id)) {
            return true;
        }
        return false;
    }

}
