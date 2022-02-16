package edu.ithaca.dturnbull.bank;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import edu.ithaca.dturnbull.bank.BankAccount.BankAccountStatus;

public class BankTellerTest {
    
    @Test
    void closeAccountTest(){
        User user = new User(new BankAccount[] {new CheckingAccount(200), new SavingAccount(200, .1, 100)}, "a@b.com", "password");
        BankTeller teller = new BankTeller("teller", "password");

        assertTrue(user.getAccount(0).status == BankAccountStatus.OPEN);
        teller.closeAccount(user.getAccount(0));
        assertTrue(user.getAccount(0).status == BankAccountStatus.CLOSED);

    }
}
