package edu.ithaca.dturnbull.bank;

import java.lang.reflect.Array;
import java.util.Arrays;

public class User {
    private BankAccount accounts[];
    private String email;
    private String password;

    /**
     * User construstor class
     * @param accounts - the accounts the User owns
     * @param userEmail - the email string they use to login to account
     * @param userPassword - the password they will use to login to account
     */
    public User(BankAccount[] userAccounts, String userEmail, String userPassword){

        if(!isEmailValid(userEmail)){
            throw new IllegalArgumentException("Invalid Email Address");
        }

        if(!isPasswordValid(userPassword)){
            throw new IllegalArgumentException("Invalid Password");
        }

        if(userAccounts == null || userAccounts.length <= 0){
            throw new IllegalArgumentException("No Valid BankAccount");
        }

        email = userEmail;
        password = userPassword;

        //Copy BankAccounts to accounts[]
        accounts = new BankAccount[userAccounts.length];
        for(int i = 0; i<userAccounts.length; i++){
            accounts[i] = userAccounts[i];
        }
    }

    /**
     * Returns wether or not the user logged in correctly
     * @param enteredEmail
     * @param enteredPassword
     * @return true if username and password are correct, false otherwise
     */
    public boolean confirmCredentials(String enteredEmail, String enteredPassword){
        
        if(email.compareTo(enteredEmail) != 0){
            return false;
        }

        if(password.compareTo(enteredPassword) != 0){
            return false;
        }

        return true;
    }

    /**
     * Adds an account to the Users list of owned accounts
     * @param account the account being added
     */
    public void AddAccount(BankAccount newAccount){

        if(!isAccountValid(newAccount)){
            throw new IllegalArgumentException("Invalid BankAccount");
        }

        int index = nextAvailableSpot();
        if(index == -1){
            extendAccountsSpace();
            index = nextAvailableSpot();
        }

        accounts[index] = newAccount;
    }

    /**
     * Returns the index of the first null item in the accounts array
     * @return the index of the first null item, -1 if there is none
     */
    private int nextAvailableSpot(){
        for(int i = 0; i<accounts.length; i++){
            if(accounts[i] == null){
                return i;
            }
        }

        return -1;
    }

    /**
     * Doubles the amount of space in the accounts array
     * @post the size of the accounts array is doubled and the orignal content is 
     * stored back into the array
     */
    private void extendAccountsSpace(){
        //copy accounts to a temp array
        BankAccount temp[] = new BankAccount[accounts.length];
        for(int i = 0; i<accounts.length; i++){
            temp[i] = accounts[i];
        }

        //double accounts size
        accounts = new BankAccount[temp.length * 2];

        //copy accounts back to accounts
        for(int i = 0; i<temp.length; i++){
            accounts[i] = temp[i];
        }
    }


    /**
     * @throws IllegalArgumentException - if index of the account does not exist
     * @param index - the index of the account
     * @return - the BankAccount
     */
    public BankAccount getAccount(int index) throws IllegalArgumentException{
        if(index >= 0 && index < accounts.length){
            return accounts[index];
        }

        throw new IllegalArgumentException("Account does not exist");
    }

    /**
     * Returns whether or not the account is valid
     * @param userAccount - the account being tested
     * @return false if account is invalid, true otherwise
     */
    public static boolean isAccountValid(BankAccount userAccount){
        if(userAccount == null){
            return false;
        }

        return true;
    }

    /**
     * Returns whether or not the given string can be a valid password
     * @param userPassword - the given string that is being tested
     * @return true if given string can be a valid password, false otherwise
     */
    public static boolean isPasswordValid(String userPassword){
        //No password rules yet
        //Only has to be a non=empty string
        if(userPassword.length() > 0)
            return true;

        return false;
    }

    /**
     * Returns whether or not the given string can be a valid email
     * @param userEmail - the given string being testes
     * @return true if the string is a valid email, false otherwise
     */
    public static boolean isEmailValid(String userEmail){
        
        if(userEmail.length() <= 0)
            return false;

        //If first character is not a letter or number
        if(userEmail.charAt(0) < 'A' || userEmail.charAt(0) > 'z'){
            return false;
        }
        else if(userEmail.charAt(0) > 'Z' && userEmail.charAt(0) < 'a'){
            return false;
        }
        else if(userEmail.charAt(0) > '9' && userEmail.charAt(0) < '0'){
            return false;
        }
        
        
        //if it does not contain an @ or has no prefix
        if (userEmail.indexOf('@') == -1 || userEmail.indexOf('@') == 0){
            return false;
        }
        else {
            //if there is more than 1 @
            int count = 0;
            for(int i = 0; i<userEmail.length(); i++){
                if(userEmail.charAt(i) == '@'){
                    count++;
                }
            }

            if(count > 1)
                return false;
        }

        int lastPeriodIndex = userEmail.lastIndexOf('.');
        //if the @ is after the period
        if(userEmail.lastIndexOf('@') > lastPeriodIndex){
            return false;
        }
        else{
            //if suffix has less than 2 characters after the period  g@f.om
            if(lastPeriodIndex > userEmail.length() - 3){
                return false;
            }


            //if a period isn't followed by a letter or number
            for(int i = 0; i < userEmail.length(); i++){
                if(userEmail.charAt(i) == '.'){
                    //period not followed by letter
                    if(userEmail.charAt(i+1) > 122 || userEmail.charAt(i+1) < 65){
                        return false;
                    }
                    else if(userEmail.charAt(i+1) > 90 && userEmail.charAt(i+1) < 97){
                            return false;
                    }
                    else if(userEmail.charAt(i+1) > '9' && userEmail.charAt(i+1) < '0'){
                        return false;
                    }
                }
            }

            //if a underscore isn't followed by a letter or number
            for(int i = 0; i < userEmail.length(); i++){
                if(userEmail.charAt(i) == '_'){
                    //period not followed by letter
                    if(userEmail.charAt(i+1) > 122 || userEmail.charAt(i+1) < 65){
                        return false;
                    }
                    else if(userEmail.charAt(i+1) > 90 && userEmail.charAt(i+1) < 97){
                            return false;
                    }
                    else if(userEmail.charAt(i+1) > '9' && userEmail.charAt(i+1) < '0'){
                        return false;
                    }
                }
            }

            //if a dash isn't followed by a letter or number
            for(int i = 0; i < userEmail.length(); i++){
                if(userEmail.charAt(i) == '-'){
                    //period not followed by letter
                    if(userEmail.charAt(i+1) > 122 || userEmail.charAt(i+1) < 65){
                        return false;
                    }
                    else if(userEmail.charAt(i+1) > 90 && userEmail.charAt(i+1) < 97){
                            return false;
                    }
                    else if(userEmail.charAt(i+1) > '9' && userEmail.charAt(i+1) < '0'){
                        return false;
                    }
                }
            }
        }

        //if any domain character isn't a lower case letter or period
        for(int i = userEmail.indexOf('@') + 1; i < userEmail.length(); i++){
            if(userEmail.charAt(i) < 97 || userEmail.charAt(i) > 122){
                if(userEmail.charAt(i) != '.'){
                    return false;
                }             
            }
        }

        return true;

        
    }

}
