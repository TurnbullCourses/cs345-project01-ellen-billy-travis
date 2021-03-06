package edu.ithaca.dturnbull.bank;

public class SavingAccount extends BankAccount{

    private double interestRate;
    private double maxDailyWithdrawAmount;

    /**
     * The constructor for the SavingAccount class. A new SavingsAccount will start with a user-determined
     * amount, interest rate, and maximum daily withdraw amount. It will also start with open status,
     * and history that only includes "Account Opened"
     * @param startingBalance
     * @param startingInterestRate
     * @param maxWithdraw
     */
    public SavingAccount(double startingBalance, double startingInterestRate, double maxWithdraw){
        if(isAmountValid(startingBalance))
            this.balance = startingBalance;

        //should probably Test these
        interestRate = startingInterestRate;
        maxDailyWithdrawAmount = maxWithdraw;

        status = BankAccountStatus.OPEN;
        accountType = BankAccountType.SAVINGS;
        history = new String[]{"Account Opened"};
    }


    /**
     * Adds interest to the balace
     * @post interest is added to the account's balance
     */
    public void compoundDailyInterest(){
        balance *= interestRate;
        addToHistory("Interest compounded, balance is now " + balance);
    }
}
