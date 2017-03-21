package hw.epam.txtaccount;

import org.junit.Test;

public class ReadTransactionsTest {
    @Test
    public void readTransactionsFromFile() throws Exception {
        String[] test1 = ("hhh" + "\n" +
                "ttt" + "\n" +
                "fdgfd" + "\n" +
                "dgdf").split("\n");
        for (String test: test1){

            System.out.println(test);
        }
        System.out.println(new Bank().readInfoAboutTransactions(
                "C://ivan//java//epamhw//unit07//task01//src//transactions/transactions.txt"));
        new Bank().readTransactionsFromFile(
                "C://ivan//java//epamhw//unit07//task01//src//transactions/transactions.txt");

    }

}