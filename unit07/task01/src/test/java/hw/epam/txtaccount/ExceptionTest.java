package hw.epam.txtaccount;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ExceptionTest {
    @Test(expected = OperationNotSupportedException.class)
    public void readTransactionsFromFile() throws Exception {
        Bank testingUnit = new Bank();
        testingUnit.readTransactionsFromFile(
                "C://ivan//java//epamhw//unit07//task01//src//transactions/forexceptions.txt");

    }

}