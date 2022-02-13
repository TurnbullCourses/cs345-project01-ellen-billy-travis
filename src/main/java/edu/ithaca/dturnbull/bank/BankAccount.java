package edu.ithaca.dturnbull.bank;

public abstract class BankAccount {

    protected String history[];
    protected BankAccountType accountType;
    protected BankAccountStatus status;
    protected double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    /*public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }*/

    public double getBalance(){
        return balance;
    }

    /*public String getEmail(){
        return email;
    }
    */

    /**
     * 
     * @param amount
     * @return true if the amount is positive and has two decmial points or less
     * @throws IllegalArgumentException if too many decimals are entered
     */
    public static boolean isAmountValid(double amount){
        if((amount*100)%1 != 0){
            throw new IllegalArgumentException("Too many decimals, please enter a valid amount.");
        }
        else if(amount < 0 ){
            throw new IllegalArgumentException("Please enter a positive amount.");
        }
        else{
            return true;
        }
    }

    /**
     * 
     * @param amount
     * increases the balance by the amount is the amount is non-negative
     */
    public void deposit(double amount){
        if(isAmountValid(amount)){
            balance += amount;
        }
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount) throws InsufficientFundsException{
        if (amount <= balance){
            balance -= amount;
        }
        else {
            throw new InsufficientFundsException("Not enough money");
        }
    }

/*
    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }
        else {
            return true;
        }
    }
*/

enum BankAccountType{
    CHECKING, SAVINGS;
}

enum BankAccountStatus{
    OPEN, FROZEN, CLOSED;
}

}

