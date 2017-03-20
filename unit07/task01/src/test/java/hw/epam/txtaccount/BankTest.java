package hw.epam.txtaccount;

import org.junit.Test;


public class BankTest {
    @Test
    public void createAccount() throws Exception {
        Bank bank = new Bank();
        bank.createAccount(1, 32);
        bank.createAccount(2, 432);
        System.out.println(bank.getAccounts());
    }

    @Test
    public void transferMoney() throws Exception {
        System.out.println("trans");
        Bank bank = new Bank();
        Account acc1 = bank.createAccount(32, 32);
        Account acc2 = bank.createAccount(432, 432);
        System.out.println(bank.getAccounts());
        bank.transfer(acc2, acc1, 100);
        bank.transfer(acc2, acc1, 100);
        bank.transfer(acc2, acc1, 100);
        bank.transfer(acc2, acc1, 100);
        Thread.sleep(7);
        System.out.println(bank.getAccounts());
    }


    @Test
    public void depositMoney() throws Exception {
        System.out.println("dep");
        Bank bank1 = new Bank();
        Account acc1 = bank1.createAccount(543, 43);
        Account acc2 = bank1.createAccount(5445, 433);
        System.out.println(bank1.getAccounts());
        bank1.deposit(acc1, 50);
        bank1.deposit(acc1, 50);
        bank1.deposit(acc1, 50);
        bank1.deposit(acc2, 100);
        bank1.deposit(acc2, 100);
        bank1.deposit(acc2, 100);
        bank1.deposit(acc2, 100);
        bank1.deposit(acc2, 100);
        bank1.deposit(acc2, 100);
        Thread.sleep(1);
        System.out.println(bank1.getAccounts());
    }


}