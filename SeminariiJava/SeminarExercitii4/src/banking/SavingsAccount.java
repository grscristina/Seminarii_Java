package banking;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String owner, double initialBalance, double interestRate) throws InvalidAmountException {
        super(owner, initialBalance);
        if (interestRate < 0) {
            throw new InvalidAmountException("Interest rate cannot be negative.");
        }
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }

    public void applyInterest() {
        double interest = getBalance() * interestRate;

        try {
            deposit(interest);
            System.out.println("Interest of " + interest + " applied at rate " + (interestRate * 100) + "%");
        } catch (InvalidAmountException e) {

            System.out.println("Error applying interest: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount{owner='" + getOwner() + "', balance=" + getBalance() +
                ", interestRate=" + (interestRate * 100) + "%}";
    }
}
