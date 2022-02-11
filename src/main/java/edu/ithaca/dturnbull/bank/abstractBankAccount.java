package edu.ithaca.dturnbull.bank;

abstract class abstractBankAccount {

    abstract double getBalance();
    
    abstract String getEmail();
    
    abstract boolean isAmountValid(double amount);
    
    abstract void deposit(double amount);
    
    abstract void withdraw(double amount);
    
    abstract void transfer(double amount);
    
    abstract boolean isEmailValid(String email);

    abstract void checkHistory();
}

