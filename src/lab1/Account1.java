package lab1;

import java.util.ArrayList;

public class Account1 extends Account{
    private static String name = "";
    private static ArrayList transactions = new ArrayList();

    Account1(String name, int id, double balance){
        super(id, balance);
        this.name = name;
        super.dateSetter();
    }

    @Override
    public void withdraw(double money){
        super.withdraw(money);
        transactions.add(new Transaction('w', money, super.getBalance(), "Withdrawal of RM" + money));
    }

    @Override
    public void deposit(double money){
        super.deposit(money);
        transactions.add(new Transaction('d', money, super.getBalance(), "Deposit of RM" + money));
    }

    public String toString(){
        return "Name: " + name +
                "\nInterest Rate: " + getAnnualInterestRate() +
                "\nBalance: RM" + getBalance() +
                "\nTransaction History: \n" + transactions.toString();
    }
}
