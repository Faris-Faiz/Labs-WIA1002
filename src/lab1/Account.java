package lab1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Account {
    private static int id = 0;
    private static double balance = 0, annualInterestRate = 0;
    private static String dateCreated = "";

    Account(){
        dateSetter();
    }

    Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        dateSetter();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double money){
        balance -= money;
    }

    public void deposit(double money){
        balance += money;
    }

    public void dateSetter(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        dateCreated = dtf.format(now);
    }
}
