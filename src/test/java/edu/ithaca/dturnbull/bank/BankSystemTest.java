package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BankSystemTest {
    @Test
    void loginToAccountTest(){
        BankSystem.addUser(new User(new BankAccount[]{new CheckingAccount(100)}, "a@b.com", "P@ssword1"));
        BankSystem.addTeller(new BankTeller("b@a.net", "P@assword2"));

        //Successful login
        assertFalse(BankSystem.loginToAccount("a@b.com", "P@ssword1") == null);

        //Unsuccessful login
        assertTrue(BankSystem.loginToAccount("word", "word") == null);

        //Username doesn't match
        assertTrue(BankSystem.loginToAccount("this is wrong", "P@ssword1") == null); // way off
        assertTrue(BankSystem.loginToAccount("a@b.com ", "P@ssword1") == null); //one character too many
        assertTrue(BankSystem.loginToAccount("a@b.co", "P@ssword1") == null); // one character short

        //Password doesn't match
        assertTrue(BankSystem.loginToAccount("a@b.com", "boom shaka lacka") == null);// way off
        assertTrue(BankSystem.loginToAccount("a@b.com", "P@ssword") == null); //one character short
        assertTrue(BankSystem.loginToAccount("a@b.com", "P@ssword1 ") == null); //one character too many



    }
}
