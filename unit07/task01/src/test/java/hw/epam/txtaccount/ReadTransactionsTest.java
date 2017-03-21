package hw.epam.txtaccount;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ReadTransactionsTest {
    @Test
    public void readTransactionsFromFile() throws Exception {
        Bank testingUnit = new Bank();
        testingUnit.readTransactionsFromFile(
                "C://ivan//java//epamhw//unit07//task01//src//transactions/transactions.txt");
        Thread.sleep(100);
        Map<Integer, Account> result = new HashMap<>();
        result.put(0, new Account(0,0));
        result.put(1, new Account(1,200));
        result.put(2, new Account(2,150));
        result.put(3, new Account(3,50));
        result.put(4, new Account(4,150));
        result.put(5, new Account(5,50));
        result.put(6, new Account(6,100));
        System.out.println(result);
        Assert.assertEquals(result, testingUnit.getAccounts());
    }

}