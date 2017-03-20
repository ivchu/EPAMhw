package hw.epam.txtaccount;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {

    private volatile int idForCreation = 0;
    private List<Account> accounts = new ArrayList<>();

    public void transfer(Account from, Account to, int amountOfMoney) {
        Transferer transferer = new Transferer(from, to, amountOfMoney);
        transferer.start();
    }

    public void deposit(Account to, int amount) {
        Depositer depositer = new Depositer(to, amount);
    }

    static void transferMoney(Account from, Account to, int amount) {
        synchronized (from) {
            synchronized (to) {

            }
        }

    }

    static void depositMoney(Account to, int amount) {
        synchronized (to) {

        }
    }

    public void createAccount() {
        Account newAccount = new Account(idForCreation++, 0);
        accounts.add(newAccount);
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }
}
