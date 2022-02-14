package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    
    @Test
    void constructorTest(){
        BankAccount account1 = new CheckingAccount(100);
        BankAccount account2 = new SavingAccount(200, .01, 100);
        
        BankAccount accounts1[] = {};
        BankAccount accounts2[] = {account1};
        BankAccount accounts3[] = {account1, account2};


        
        User user2 = new User(accounts2, "a@b.com", "123"); //1 accounts
        User user3 = new User(accounts3, "a@b.com", "123"); //2 accounts

        //Checking Accounts
        assertTrue(account1 == user2.getAccount(0));
        assertTrue(account1 == user3.getAccount(0));

        //Savings Accounts
        assertTrue(account2 == user3.getAccount(1));
        
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

    }

    @Test
    void confirmCredentialsTest(){
        BankAccount accounts[] = {};
        User user1 = new User(accounts, "a@b.com", "password");

        assertTrue(user1.confirmCredentials("a@b.com", "password")); //Matches exactly
        
        //Only password matches
        assertFalse(user1.confirmCredentials("a@b.co", "password")); //one character off
        assertFalse(user1.confirmCredentials("@b.com", "password")); //one character off
        assertFalse(user1.confirmCredentials("", "password")); //empty string
        assertFalse(user1.confirmCredentials("a@b.comm", "password")); //extra characters
        assertFalse(user1.confirmCredentials("a@b.com ", "password")); //extra characters - space


        //Only email matches
        assertFalse(user1.confirmCredentials("a@b.com", "assword")); // <-lol - one character off
        assertFalse(user1.confirmCredentials("a@b.com", "passwor")); //one character off
        assertFalse(user1.confirmCredentials("a@b.com", "")); //empty string
        assertFalse(user1.confirmCredentials("a@b.com", "passwordd")); //extra characters
        assertFalse(user1.confirmCredentials("a@b.com", "password ")); //extra characters - space

        
    }

    
}
