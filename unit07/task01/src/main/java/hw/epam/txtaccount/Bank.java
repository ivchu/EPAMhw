package hw.epam.txtaccount;


import javax.naming.OperationNotSupportedException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    private volatile HashMap<Integer, Account> accounts = new HashMap<>();

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

    public void readTransactionsFromFile(String fileName) throws IOException, OperationNotSupportedException {
        String[] lines = readInfoAboutTransactions(fileName).split("\\r\\n");
        for (String s : lines)  {
            String[] partsOfTransaction = s.split(" ");
            String transactiontype = partsOfTransaction[0].toLowerCase();
            synchronized (accounts) {
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
                            throw new OperationNotSupportedException("transfer cant be made from account without money");
                        }
                        break;
                    case "deposit":
                        Integer accountToD = Integer.parseInt(partsOfTransaction[1]);
                        Integer amountD = Integer.parseInt(partsOfTransaction[2]);
                        if (accounts.containsKey(accountToD)) {
                            this.deposit(accounts.get(accountToD), amountD);
                        } else {
                            this.createAccount(accountToD, amountD);
                        }
                        break;
                    default:
                        throw new IllegalStateException("some shit with file");
                }
            }
        }
    }

    private String readInfoAboutTransactions(String fileName) throws IOException {
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
        return accounts;
    }
}
