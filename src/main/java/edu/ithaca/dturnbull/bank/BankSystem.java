package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

public class BankSystem {
    private static ArrayList<User> allUsers;
    private static ArrayList<BankTeller> allTellers;
    //private static ArrayList<BankAccount> allBankAccounts;

    public BankSystem(){
        allUsers = new ArrayList<User>();
        allTellers = new ArrayList<BankTeller>();
    }

    public User loginToAccount(String email, String pass){
        for (User user : allUsers) {
            if(user.confirmCredentials(email, pass)){
                return user;
            }
        }

        return null;
    }

    public BankTeller loginToTellerAccount(String email, String pass){
        for (BankTeller teller : allTellers) {
            if(teller.confirmCredentials(email, pass)){
                return teller;
            }
        }

        return null;
    }

    /**
     * Adds a user to the allUsers Array
     * @param user the user being added
     */
    public void addUser(User user){
        allUsers.add(user);
    }

    /**
     * Adds a teller to the allTellers array
     * @param teller - the teller being added
     */
    public void addTeller(BankTeller teller){
        allTellers.add(teller);
    }
    
}
