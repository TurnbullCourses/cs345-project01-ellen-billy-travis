package edu.ithaca.dturnbull.bank;

public class BankSystem {
    private static User allUsers[] = {new User(new BankAccount[]{new CheckingAccount(100)}, "a@b.com" , "P@ssword")};
    private static Teller allTellers[];
    private static BankAccount allBankAccounts[] = {new CheckingAccount(100)};

    public static User loginToAccount(String email, String pass){
        for (User user : allUsers) {
            if(user.confirmCredentials(email, pass)){
                return user;
            }
        }

        return null;
    }

    /**
     * Adds a user to the allUsers Array
     * @param user the user being added
     */
    public static void addUser(User user){

    }

    /**
     * Adds an account to the allAccounts array
     * @param account - the account being added
     */
    public static void addAccount(BankAccount account){

    }

    /**
     * Adds a teller to the allTellers array
     * @param teller - the teller being added
     */
    public static void addTeller(Teller teller){

    }
    
}
