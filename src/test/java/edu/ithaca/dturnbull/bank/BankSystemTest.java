package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BankSystemTest {
    @Test
    void loginToAccountTest(){
        BankSystem Bank = new BankSystem();
        Bank.addUser(new User(new BankAccount[]{new CheckingAccount(100)}, "a@b.com", "P@ssword1"));
        Bank.addTeller(new BankTeller("b@a.net", "P@assword2"));

        //Successful login
        assertFalse(Bank.loginToAccount("a@b.com", "P@ssword1") == null);

        //Unsuccessful login
        assertTrue(Bank.loginToAccount("word", "word") == null);

        //Username doesn't match
        assertTrue(Bank.loginToAccount("this is wrong", "P@ssword1") == null); // way off
        assertTrue(Bank.loginToAccount("a@b.com ", "P@ssword1") == null); //one character too many
        assertTrue(Bank.loginToAccount("a@b.co", "P@ssword1") == null); // one character short

        //Password doesn't match
        assertTrue(Bank.loginToAccount("a@b.com", "boom shaka lacka") == null);// way off
        assertTrue(Bank.loginToAccount("a@b.com", "P@ssword") == null); //one character short
        assertTrue(Bank.loginToAccount("a@b.com", "P@ssword1 ") == null); //one character too many



    }

    @Test
    void loginToTellerAccountTest(){
        BankSystem Bank = new BankSystem();
        Bank.addTeller(new BankTeller("b@a.net", "P@ssword2"));

        //Successful login
        assertFalse(Bank.loginToTellerAccount("b@a.net", "P@ssword2") == null);


        //Unsuccessful login
        assertTrue(Bank.loginToTellerAccount("word", "word") == null);

        //Username doesn't match
        assertTrue(Bank.loginToTellerAccount("this is wrong", "P@ssword2") == null); // way off
        assertTrue(Bank.loginToTellerAccount("b@a.net ", "P@ssword2") == null); //one character too many
        assertTrue(Bank.loginToTellerAccount("@a.net", "P@ssword2") == null); // one character short

        //Password doesn't match
        assertTrue(Bank.loginToTellerAccount("b@a.net", "boom shaka lacka") == null);// way off
        assertTrue(Bank.loginToTellerAccount("b@a.net", "P@ssword") == null); //one character short
        assertTrue(Bank.loginToTellerAccount("b@a.net", "P@ssword2 ") == null); //one character too many



    }
}
