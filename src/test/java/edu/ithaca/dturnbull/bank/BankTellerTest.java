package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.ithaca.dturnbull.bank.BankAccount.BankAccountStatus;

public class BankTellerTest {
    @Test
    void closeAccountTest(){
        User user = new User(new BankAccount[] {new CheckingAccount(100), new SavingAccount(200, .01, 50)}, "a@b.com", "P@55w0rd");
        BankTeller teller = new BankTeller("name", "wordpass");

        assertTrue(user.getAccount(0).status == BankAccountStatus.OPEN); // checks open account

        teller.closeAccount(user.getAccount(0));

        assertTrue(user.getAccount(0).status == BankAccountStatus.CLOSED); // checks closed account
        assertTrue(user.getAccount(1).status == BankAccountStatus.OPEN); // checks open account

    }

    /**
     * Integration Tests 
     * */
    @Test
    void integrationTest() throws InsufficientFundsException{
        User user = new User(new BankAccount[] {new SavingAccount(200, .01, 50)}, "hellokitty@gmail.com", "P@55w0rd");
        BankTeller teller = new BankTeller("Harold", "0ffici@l");

        teller.createCheckingAccount(user, 1000);
        assertTrue(user.getAccount(1).status == BankAccountStatus.OPEN);

        teller.withdrawFromAccount(user.getAccount(1), 100);
        assertTrue(user.getAccount(1).getBalance() == 900);

        teller.depositToAccount(user.getAccount(1), 200);
        assertTrue(user.getAccount(1).getBalance() == 1100);
    }    
}

