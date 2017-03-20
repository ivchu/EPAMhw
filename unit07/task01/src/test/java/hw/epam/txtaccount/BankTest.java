package hw.epam.txtaccount;

import org.junit.Test;

/**
 * Created by MM8 on 20.03.2017.
 */
public class BankTest {
    @Test
    public void createAccount() throws Exception {
        Bank bank = new Bank();
        bank.createAccount();
        bank.createAccount();
        System.out.println(bank.getAccounts());
    }

}