package bankaccount;

public class BankAccount {

    private String owner;
    private double balance;


    public BankAccount() {
        owner="N/A";
        balance=0;
    }


    public BankAccount(String owner, double balance) {
        this.owner = owner;

        if (balance < 0) {
            System.out.println("Balance cannot be negative");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }


    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }


    public void setOwner(String owner) {
        this.owner = owner;
    }


    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return;
        }
        // prevent overdraft: you cannot take more than you have
        if (amount > balance) {
            System.out.println("Not enough money.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}
