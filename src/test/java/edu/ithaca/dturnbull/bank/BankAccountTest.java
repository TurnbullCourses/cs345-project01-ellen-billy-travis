package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BankAccountTest {

    @Test
    void getBalanceTest() {
        CheckingAccount bankAccount = new CheckingAccount(200);

        assertEquals(200, bankAccount.getBalance(), 0.001);
    }

    @Test
    void isAmountValidTest(){
        //Valid Cases
        assertTrue(BankAccount.isAmountValid(10.00)); 
        assertTrue(BankAccount.isAmountValid(1895.63));
        assertTrue(BankAccount.isAmountValid(170)); // no decimals

        //Invalid Cases
        assertThrows(IllegalArgumentException.class, () -> BankAccount.isAmountValid(150.232)); // too many decimals
        assertThrows(IllegalArgumentException.class, () -> BankAccount.isAmountValid(-95.12)); // Negative
        assertThrows(IllegalArgumentException.class, () -> BankAccount.isAmountValid(-50000)); // Negative edge case

    }

    @Test
    void depositTest() throws IllegalArgumentException{
        CheckingAccount bankAccount = new CheckingAccount(200);
        
        bankAccount.deposit(100);
        assertEquals(300, bankAccount.getBalance(), 0.001); // valid deposit
        bankAccount.deposit(189.99);
        assertEquals(489.99, bankAccount.getBalance(), 0.001); // valid deposit
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-500)); // negative input 
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(500.555)); // too many decimals

    }

    @Test
    void withdrawTest() throws InsufficientFundsException{
        CheckingAccount bankAccount = new CheckingAccount(200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));
    }

    /*@Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com"));   // valid email address
        assertFalse( BankAccount.isEmailValid(""));         // empty string
    }*/

    @Test
    void constructorTest() {
        CheckingAccount bankAccount = new CheckingAccount(200);

        //assertEquals("a@b.com", bankAccount.getEmail());

        assertEquals(200, bankAccount.getBalance(), 0.001);

        //Yeah, this is a comment -Travis
        //check for exception thrown correctly
        //assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}