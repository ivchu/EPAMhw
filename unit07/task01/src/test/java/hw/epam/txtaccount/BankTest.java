package hw.epam.txtaccount;

import org.junit.Test;


public class BankTest {
    @Test
    public void createAccount() throws Exception {
        Bank bank = new Bank();
        bank.createAccount();
        bank.createAccount();
        System.out.println(bank.getAccounts());
    }

    @Test
    public void depositMoney() throws Exception {
        Bank bank = new Bank();
        bank.createAccount();
        bank.createAccount();
        System.out.println(bank.getAccounts());
    }


    @Test
    public void transferMoney() throws Exception {
        Bank bank = new Bank();
        bank.createAccount();
        bank.createAccount();
        System.out.println(bank.getAccounts());
    }



}