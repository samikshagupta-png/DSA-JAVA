package oops; 

abstract class Account{
    protected String username;
    protected int accountnumber;
    protected double balance;
    public Account(String username,int accountnumber,double balance){
        this.username =username;
        this.accountnumber=accountnumber;
        this.balance= balance;
    }
    public String getusername(){
        return username;
    }
    public int getaccountnumber(){
        return accountnumber;
    }
    public double getbalance(){
        return balance;
    }
    public void credit(double amount) {
        balance += amount;
        System.out.println("Credited: " + amount + " | Balance: " + balance);
    }
    public abstract void debit(double amount);

}


class SavingsAccount extends Account {
    private double minBalance = 1000; // must maintain minimum balance

    public SavingsAccount(String username, int accountNumber, double balance) {
        super(username, accountNumber, balance);
    }

    @Override
    public void debit(double amount) {
        if (balance - amount >= minBalance) {
            balance -= amount;
            System.out.println("Debited: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Cannot debit! Minimum balance requirement.");
        }
    }
}
class CurrentAccount extends Account {
    private double overdraftLimit = 500000;

    public CurrentAccount(String username, int accountNumber, double balance) {
        super(username, accountNumber, balance);
    }

    @Override
    public void debit(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Debited: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}

class user{

}

public class bank {
    
    

    
}
