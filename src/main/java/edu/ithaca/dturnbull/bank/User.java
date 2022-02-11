package edu.ithaca.dturnbull.bank;
public class User {
    private BankAccount userAccounts[];
    private String email;
    private String password;

    public User(BankAccount[] accounts, String userEmail, String userPassword){

    }

    public boolean confirmCredentials(){
        return true;
    }

    public static boolean isEmailValid(String userEmail){
        return true;
    }

    public static boolean isPasswordValid(String userPassword){
        return true;
    }
}
