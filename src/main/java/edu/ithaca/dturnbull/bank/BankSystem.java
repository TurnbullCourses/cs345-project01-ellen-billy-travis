package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

public class BankSystem {
    private static ArrayList<User> allUsers;
    private static ArrayList<Teller> allTellers;
    //private static ArrayList<BankAccount> allBankAccounts;

    public static User loginToAccount(String email, String pass){
        for (User user : allUsers) {
            if(user.confirmCredentials(email, pass)){
                return user;
            }
        }

        return null;
    }

    public static Teller loginToTellerAccount(String email, String pass){
        for (Teller teller : allTellers) {
            if(teller.accountLogin(email, pass)){
                return teller;
            }
        }

        return null;
    }

    /**
     * Adds a user to the allUsers Array
     * @param user the user being added
     */
    public static void addUser(User user){
        allUsers.add(user);
    }

    /**
     * Adds an account to the allAccounts array
     * @param account - the account being added
     
    public static void addAccount(BankAccount account){
        allBankAccounts.add(account);
    }
    */

    /**
     * Adds a teller to the allTellers array
     * @param teller - the teller being added
     */
    public static void addTeller(Teller teller){
        allTellers.add(teller);
    }
    
}
