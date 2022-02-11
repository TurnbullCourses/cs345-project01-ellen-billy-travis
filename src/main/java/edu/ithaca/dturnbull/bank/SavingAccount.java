package edu.ithaca.dturnbull.bank;

public class SavingAccount extends abstractBankAccount{

    private double balance;

    public SavingAccount(String email, double startingBalance){
        this.balance = startingBalance;
    }

    @Override
    double getBalance() {
        // TODO Auto-generated method stub
        return balance;
    }

    @Override
    boolean isAmountValid(double amount) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    void deposit(double amount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    void withdraw(double amount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    void transfer(double amount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    void checkHistory() {
        // TODO Auto-generated method stub
        
    }
}
