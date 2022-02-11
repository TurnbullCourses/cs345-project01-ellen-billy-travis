package edu.ithaca.dturnbull.bank;

abstract class abstractBankAccount {

    abstract double getBalance();
    
    abstract boolean isAmountValid(double amount);
    
    abstract void deposit(double amount);
    
    abstract void withdraw(double amount);
    
    abstract void transfer(double amount);

    abstract void checkHistory();
}

