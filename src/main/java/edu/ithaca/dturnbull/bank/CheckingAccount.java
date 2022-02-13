package edu.ithaca.dturnbull.bank;

public class CheckingAccount extends BankAccount{

    public CheckingAccount(double startingBalance){
        if(isAmountValid(startingBalance))
            this.balance = startingBalance;

        status = BankAccountStatus.OPEN;
        accountType = BankAccountType.CHECKING;
        history = new String[]{"Account Created"};
    }




    /*
        
    ----------Unnecessary------------

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

    */
}