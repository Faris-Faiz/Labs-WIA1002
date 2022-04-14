package lab1;

import java.util.Date;

public class Transaction {
    private String date = String.valueOf(new Date());
    private char type;
    private double amount, balance;
    private String description;

    Transaction(char type, double amount, double balance, String description){
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public String toString(){
        return "Type of Transaction: " + type +
                "\nAmount: RM" + amount +
                "\nBalance: RM" + balance +
                "\nDescription of Transaction: " + description;
    }
}
