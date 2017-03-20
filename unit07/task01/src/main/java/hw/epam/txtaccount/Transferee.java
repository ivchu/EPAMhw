package hw.epam.txtaccount;


public class Transferee extends Thread {
    private Account accountFrom;
    private Account accountTo;
    private int howMuch;

    public Transferee(Account accountFrom, Account accountTo, int howMuch) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.howMuch = howMuch;
    }

    @Override
    public void run(){
        Bank.transferMoney(accountFrom, accountTo, howMuch);
    }
}
