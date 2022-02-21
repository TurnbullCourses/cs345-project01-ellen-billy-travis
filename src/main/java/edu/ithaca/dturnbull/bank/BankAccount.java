package edu.ithaca.dturnbull.bank;

public abstract class BankAccount {

    protected String history[];
    protected BankAccountType accountType;
    protected BankAccountStatus status;
    protected double balance;

    public double getBalance(){
        return balance;
    }

    public String[] getHistory(){
        return history;
    }

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
            addToHistory("Deposited " + amount + ", balance is now " + balance);
        }
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount) throws InsufficientFundsException{
        if(!isAmountValid(amount)){
            throw new IllegalArgumentException("Invalid withdraw amount");
        }

        if (amount <= balance){
            balance -= amount;
            addToHistory("Withdrew "+amount +", Balance is now " + balance);
        }
        else {
            throw new InsufficientFundsException("Not enough money");
        }
    }

    /**
     * Adds an entry to the history log
     * @param entry - the entry to be added to history
     */
    public void addToHistory(String entry){
        int index = nextAvailableSpace();

        if(index == -1){
            extendHistorySpace();
            index = nextAvailableSpace();
        }

        history[index] = entry;
    }
    /**
     * Returns the next available space for an entry in account history
     * @return the index of the next available space, -1 if there is none
     */
    private int nextAvailableSpace(){
        for(int i = 0; i< history.length; i++){
            if(history[i] == null || history[i] == ""){
                return i;
            }
        }
        return -1;
    }
    /**
     * Doubles the length of the history array and preserves the existing data
     * @post history length is doubled and the original data is preserved
     */
    private void extendHistorySpace(){
        //copy history to a temp array
        String temp[] = new String[history.length];
        for(int i = 0; i<history.length; i++){
            temp[i] = history[i];
        }

        //double accounts size
        history = new String[temp.length * 2];

        //copy accounts back to accounts
        for(int i = 0; i<temp.length; i++){
            history[i] = temp[i];
        }
    }


enum BankAccountType{
    CHECKING, SAVINGS;
}

enum BankAccountStatus{
    OPEN, FROZEN, CLOSED;
}

}

