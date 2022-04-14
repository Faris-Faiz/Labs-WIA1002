package lab1;

public class Question3Main {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000.00);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Monthly Interest: $" + account.getMonthlyInterest());
        System.out.println("Account created on: " + account.getDateCreated());
        System.out.println("");

        Account1 account1 = new Account1("George", 1122, 1000);
        account1.setAnnualInterestRate(1.5);
        account1.deposit(30);
        account1.deposit(40);
        account1.deposit(50);
        account1.withdraw(5);
        account1.withdraw(4);
        account1.withdraw(2);
        System.out.println(account1.toString());
    }
}
