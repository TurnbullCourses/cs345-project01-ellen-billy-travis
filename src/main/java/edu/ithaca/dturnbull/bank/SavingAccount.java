package edu.ithaca.dturnbull.bank;

public class SavingAccount extends BankAccount{

    private double interestRate;
    private double maxDailyWithdrawAmount;

    public SavingAccount(double startingBalance, double startingInterestRate, double maxWithdraw){
        if(isAmountValid(startingBalance))
            this.balance = startingBalance;

        //should probably Test these
        interestRate = startingInterestRate;
        maxDailyWithdrawAmount = maxWithdraw;

        status = BankAccountStatus.OPEN;
        accountType = BankAccountType.CHECKING;
        history = new String[]{"Account Created"};
    }


    public void compoundDailyInterest(){
        
    }

    /*
    
    --------------Unnecessary-------------

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
