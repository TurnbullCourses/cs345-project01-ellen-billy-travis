package edu.ithaca.dturnbull.bank;

import edu.ithaca.dturnbull.bank.BankAccount.BankAccountStatus;
import edu.ithaca.dturnbull.bank.BankAccount.BankAccountType;

public class BankTeller extends Teller{
    private String username;
    private String password;

    public BankTeller(String userUsername, String userPassword){
        username = userUsername;
        password = userPassword;
    }

    public void createSavingsAccount(User owner, double startingBalance, double startingInterestRate, double maxWithdraw){
        BankAccount account = new SavingAccount(startingBalance, startingInterestRate, maxWithdraw);
        owner.AddAccount(account);
    }

    public void createCheckingAccount(User owner, double startingBalance){
        BankAccount account = new CheckingAccount(startingBalance);
        owner.AddAccount(account);
    }

    public void closeAccount(BankAccount account){
        account.status = BankAccountStatus.CLOSED;
    }
}
