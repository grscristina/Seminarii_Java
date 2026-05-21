package banking;

public class Main {

    public static void main(String[] args) {

        BankAccount account1 = null;
        SavingsAccount savings1 = null;

        try {
            account1 = new BankAccount("Ion Popescu", 500.0);
            savings1 = new SavingsAccount("Maria Ionescu", 1000.0, 0.05);

        } catch (InvalidAmountException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }


        System.out.println("\nDeposits:");
        try {
            account1.deposit(200.0);
            savings1.deposit(500.0);
        } catch (InvalidAmountException e) {
            System.out.println("Deposit error: " + e.getMessage());
        }


        System.out.println("\nWithdrawals");
        try {
            account1.withdraw(100.0);
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Withdrawal error: " + e.getMessage());
        }


        System.out.println("\nApply Interest");
        savings1.applyInterest();

        System.out.println("\nInvalid Deposit (amount = 0)");
        try {
            account1.deposit(0);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("\nInvalid Deposit");
        try {
            account1.deposit(-50);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("\nInsufficient Funds");
        try {
            account1.withdraw(99999.0);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("\nInvalid Initial Balance");
        try {
            BankAccount bad = new BankAccount("Hacker", -100.0);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println(account1);
        System.out.println(savings1);
    }
}
