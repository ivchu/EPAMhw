package hw.epam.txtaccount;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    //    private Set<Integer> accountIds = new HashSet<>();
    private HashMap<Integer, Account> accounts = new HashMap<>();

    public void transfer(Account from, Account to, int amountOfMoney) {
        Transferee transferee = new Transferee(from, to, amountOfMoney);
        transferee.start();
    }

    public void deposit(Account to, int amount) {
        Depositor depositor = new Depositor(to, amount);
        depositor.start();
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

    public Account createAccount(Integer accountId, Integer amountOfMoney) {
        synchronized (accounts) {
            if (accounts.containsKey(accountId)) {
                throw new IllegalArgumentException("аккаунт с таким Id уже существует");
            }
            Account newAccount = new Account(accountId, amountOfMoney);
            accounts.put(accountId, newAccount);
            return newAccount;
        }
    }

    public void readTransactionsFromFile(String fileName) throws IOException {
        String[] lines = readInfoAboutTransactions(fileName).split("\n");
        for (String s: lines) {
            System.out.println(s);
        }
        for (String s : lines) {
            String[] partsOfTransaction = s.split(" ");
            System.out.println(partsOfTransaction);
            String transactiontype = partsOfTransaction[0].toLowerCase();
            switch (transactiontype) {
                case "transfer":
                    Integer accountFrom = Integer.parseInt(partsOfTransaction[1]);
                    Integer accountTo = Integer.parseInt(partsOfTransaction[2]);
                    Integer amount = Integer.parseInt(partsOfTransaction[3]);
                    if (accounts.containsKey(accountFrom)) {
                        if (accounts.containsKey(accountTo)) {
                            this.transfer(accounts.get(accountFrom), accounts.get(accountTo), amount);
                        } else {
                            this.transfer(accounts.get(accountFrom), this.createAccount(accountTo, 0), amount);
                        }
                    } else {
                        throw new IllegalArgumentException("transfer cant be made from account without money");
                    }
                    break;
                case "deposit":
                    Integer accountToD = Integer.parseInt(partsOfTransaction[1]);
                    Integer amountD = Integer.parseInt(partsOfTransaction[2]);
                    if (accounts.containsKey(accountToD)){
                        this.deposit(accounts.get(accountToD), amountD);
                    } else {
                        this.createAccount(accountToD, amountD);
                    }

            }
        }
    }

    public String readInfoAboutTransactions(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        StringBuilder result = new StringBuilder();
        int data;
        while ((data = fileInputStream.read()) != -1) {
            result.append((char) data);
        }
        fileInputStream.close();
        return result.toString();
    }

    public Map<Integer, Account> getAccounts() {
        return Collections.unmodifiableMap(accounts);
    }
}
