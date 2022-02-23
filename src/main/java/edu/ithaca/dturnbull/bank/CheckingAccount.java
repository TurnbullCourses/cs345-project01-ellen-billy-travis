package edu.ithaca.dturnbull.bank;

public class CheckingAccount extends BankAccount{

    /**
     * The constructor for the CheckingAccount class. A new checking account
     * will start with a determined amount, open status, and a history that
     * says "Account Opened"
     * @param startingBalance
     */
    public CheckingAccount(double startingBalance){
        if(isAmountValid(startingBalance))
            this.balance = startingBalance;

        status = BankAccountStatus.OPEN;
        accountType = BankAccountType.CHECKING;
        history = new String[]{"Account Opened"};
    }

}