package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    
    @Test
    void constructorTest(){
        BankAccount account1 = new CheckingAccount(100);
        BankAccount account2 = new SavingAccount(200, .01, 100);
        
        BankAccount accounts1[] = new BankAccount[]{};
        BankAccount accounts2[] = new BankAccount[]{account1};
        BankAccount accounts3[] = new BankAccount[]{account1, account2};


        
        User user2 = new User(accounts2, "a@b.com", "123"); //1 accounts
        User user3 = new User(accounts3, "a@b.com", "123"); //2 accounts

        //Checking Accounts
        assertTrue(account1.balance == user2.getAccount(0).balance);
        assertTrue(account1.balance == user3.getAccount(0).balance);

        //Savings Accounts
        assertTrue(account2.balance == user3.getAccount(1).balance);
        
        //Zero accounts
        assertThrows(IllegalArgumentException.class,() -> new User(accounts1, "a@b.com", "123")); //0 accounts)
    }

    @Test
    void isEmailValidTest(){
        assertTrue(User.isEmailValid( "a@b.com"));   // valid email address
        assertFalse( User.isEmailValid(""));         // empty string
        assertFalse(User.isEmailValid("@.com"));     //no prefix incomplete suffix -> Boundary value: At least one character in prefix
        assertFalse( User.isEmailValid("ab@c@d@.com"));  //mulitple @ symbols -> Equivalence: invalid characters in prefix
        assertFalse( User.isEmailValid(".com@"));    //incorrectly formatted suffix -> Equivalence: invalid characters in prefix
        assertFalse(User.isEmailValid("abc@gmail.v")); // valid prefix invalid suffix
        assertTrue(User.isEmailValid("ab@gmail.com")); //prefix with only two letters
        assertTrue(User.isEmailValid("wizard.ofoz@ithaca.edu")); //prefix with period
        assertFalse( User.isEmailValid("rumplestiltskin.com")); //no @ symbol
        assertFalse( User.isEmailValid("pinocchio@gmail.com$")); //invalid suffix
        assertFalse( User.isEmailValid("captain.@hook.com")); //period with no character after
        assertFalse( User.isEmailValid("jiminy_@cricket.com"));//underscore with no character after
    }

    @Test 
    void isPasswordValidTest(){

        assertTrue(User.isPasswordValid("P@55w0rd"));

        //Empty string fails
        assertFalse(User.isPasswordValid(""));

        //not all requirements met
        assertFalse(User.isPasswordValid("Password")); //no symbol
        assertFalse(User.isPasswordValid("password#")); //no uppercase letter
        assertFalse(User.isPasswordValid("P@5s")); //not long enough
        assertFalse(User.isPasswordValid("PasswordP@55w0rd")); //too long
    }
    
    @Test
    void AddAccountTest(){
        BankAccount account1 = new CheckingAccount(100);
        BankAccount account2 = new SavingAccount(200, .01, 100);
        BankAccount account3 = new SavingAccount(300, .01, 100);
        
        BankAccount accounts1[] = new BankAccount[]{account1};

        User user1 = new User(accounts1, "a@b.com", "123"); //1 accounts

        //Add Savings Accounts
        user1.AddAccount(new SavingAccount(400, .01, 100));
        assertTrue(user1.getAccount(1).balance == 400);

        //Add Checking Accounts
        user1.AddAccount(new CheckingAccount(450));
        assertTrue(user1.getAccount(2).balance == 450);

        //Add Null Account
        assertThrows(IllegalArgumentException.class, () -> user1.AddAccount(null));
    }

    @Test
    void confirmCredentialsTest(){
        BankAccount accounts[] = {};
        User user1 = new User(accounts, "a@b.com", "P@55w0rd");

        assertTrue(user1.confirmCredentials("a@b.com", "P@55w0rd")); //Matches exactly
        
        //Only password matches
        assertFalse(user1.confirmCredentials("a@b.co", "P@55w0rd")); //one character off
        assertFalse(user1.confirmCredentials("@b.com", "P@55w0rd")); //one character off
        assertFalse(user1.confirmCredentials("", "P@55w0rd")); //empty string
        assertFalse(user1.confirmCredentials("a@b.comm", "P@55w0rd")); //extra characters
        assertFalse(user1.confirmCredentials("a@b.com ", "P@55w0rd")); //extra characters - space


        //Only email matches
        assertFalse(user1.confirmCredentials("a@b.com", "assword")); // <-lol - one character off
        assertFalse(user1.confirmCredentials("a@b.com", "passwor")); //one character off
        assertFalse(user1.confirmCredentials("a@b.com", "")); //empty string
        assertFalse(user1.confirmCredentials("a@b.com", "passwordd")); //extra characters
        assertFalse(user1.confirmCredentials("a@b.com", "password ")); //extra characters - space
    }
    

    
}
