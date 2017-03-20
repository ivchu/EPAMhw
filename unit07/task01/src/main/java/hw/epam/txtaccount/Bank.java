package hw.epam.txtaccount;


import java.util.*;

public class Bank {
    private Set<Integer> accountIds = new HashSet<>();
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
                final int currentMoneyTo = to.getAmountOfMoney();
                final int currentMoneyFrom = from.getAmountOfMoney();
                final int newAmountFrom = currentMoneyFrom - amount;
                final int newAmountTo = currentMoneyTo + amount;
                from.setAmountOfMoney(newAmountFrom);
                to.setAmountOfMoney(newAmountTo);
            }
        }

    }

    static void depositMoney(Account to, int amount) {
        synchronized (to) {
            final int currentMoney = to.getAmountOfMoney();
            final int newAmount = amount + currentMoney;
            to.setAmountOfMoney(newAmount);
        }
    }

    public void createAccount(Integer accountId, Integer amountOfMoney) {
        synchronized (accountIds) {
            Account newAccount = new Account(accountId, amountOfMoney);
            accountIds.add(accountId);
            synchronized (accounts) {
                accounts.add(newAccount);
            }
        }
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }
}
