package hw.epam.txtaccount;


public class Transferer extends Thread {
    private Account accountFrom;
    private Account accountTo;
    private int howMuch;

    public Transferer(Account accountFrom, Account accountTo, int howMuch) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.howMuch = howMuch;
    }

    @Override
    public void run(){

    }
}
