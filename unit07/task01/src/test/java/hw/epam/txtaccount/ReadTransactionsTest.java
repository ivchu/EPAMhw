package hw.epam.txtaccount;

import org.junit.Test;

public class ReadTransactionsTest {
    @Test
    public void readTransactionsFromFile() throws Exception {
        Bank testingUnit = new Bank();
        testingUnit.readTransactionsFromFile(
                "C://ivan//java//epamhw//unit07//task01//src//transactions/transactions.txt");
        System.out.println(testingUnit.getAccounts());
        Thread.sleep(100);
        System.out.println(testingUnit.getAccounts());
    }

}