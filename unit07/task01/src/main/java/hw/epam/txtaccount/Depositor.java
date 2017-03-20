package hw.epam.txtaccount;


public class Depositor extends Thread{
    private Account accountTo;
    private int howMuch;

    public Depositor(Account accountTo, int howMuch) {
        this.accountTo = accountTo;
        this.howMuch = howMuch;
    }

    @Override
    public void run() {
        Bank.depositMoney(accountTo, howMuch);
    }
}
