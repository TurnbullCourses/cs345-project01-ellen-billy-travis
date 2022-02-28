package edu.ithaca.dturnbull.bank;

public abstract class Teller {
    
    /**
     * The login check for the user
     * @param user - the user account to login to
     * @param email - the entered email string
     * @param password - the entered password string
     * @return true if the correct email and password for the given user
     */
    public boolean userLogin(User user, String email, String password){
        return user.confirmCredentials(email, password);
    }

    /**
     * Displays the balance for the given account
     * @param account - the account to display the balance from
     */
    public void checkBalance(BankAccount account){
        account.getBalance();
    }

    /**
     * Subtracts the given amount from the given account
     * @param account - the account being withdrawed from
     * @param amount -  the amount wished to be withdrawn
     */
    public void withdrawFromAccount(BankAccount account, double amount) throws InsufficientFundsException{
        account.withdraw(amount);
    }

    public void depositToAccount(BankAccount account, double amount){
        account.deposit(amount);
    }

    /**
     * Subtracts the given from one account and adds it to another account
     * @param fromAccount - The account that money is being taken form
     * @param toAccount -  the account that is receiving money
     * @param amount - the amount being transferred
     */
    public void transferBetweenAccount(BankAccount fromAccount, BankAccount toAccount, double amount){
        
    }

    /**
     * Returns the history of the account
     * @param account - the account that the history is retrieved from
     * @return the account history
     */
    public String[] getAccountHistory(BankAccount account){
        return account.getHistory();
    } 
}
