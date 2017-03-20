package hw.epam.txtaccount;


import java.util.ArrayList;
import java.util.List;

public class Bank {
    public static void main(String[] args) {
        System.out.println(new Account(15, 20).toString());
    }
    private volatile int idForCreation = 0;
    private List<Account> accounts = new ArrayList<>();

    public void transferMoney(Account from, Account to){
        synchronized (from){
            synchronized (to){

            }
        }

    }

    public void depositMoney(Account to){
        synchronized (to){

        }
    }

    public void createAccount(){
        Account newAccount = new Account(idForCreation++, 0);
        accounts.add(newAccount);
    }
}
