package hw.epam.txtaccount;


public class Depositer extends Thread{
    private Account accountTo;
    private int howMuch;

    public Depositer(Account accountTo, int howMuch) {
        this.accountTo = accountTo;
        this.howMuch = howMuch;
    }

    @Override
    public void run() {

    }
}
