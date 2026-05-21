package bankaccount;

public class Main {
    public static void main(String[] args) {


        BankAccount acc1 = new BankAccount("Ion", 100);
        System.out.println(acc1);


        acc1.deposit(50);
        acc1.withdraw(30);
        acc1.withdraw(500);
        acc1.deposit(-20);
        BankAccount acc2 = new BankAccount("Maria", -200);
        System.out.println(acc2);

        System.out.println(acc1);
    }
}
