package banking;

public class BankAccount {

    private String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) throws InvalidAmountException {
        if (initialBalance < 0) {
            throw new InvalidAmountException("Initial balance cannot be negative.");
        }
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getOwner() { return owner; }
    public double getBalance() { return balance; }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than 0:" + amount);
        }
        balance += amount;
        System.out.println("Deposited " + amount + " to " + owner + "s account. New balance: " + balance);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than 0. Got: " + amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds! Tried to withdraw " + amount + " but balance is " + balance
            );
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " from " + owner + "'s account. New balance: " + balance);
    }

    @Override
    public String toString() {
        return "BankAccount{owner='" + owner + "', balance=" + balance + "}";
    }
}
