package stationery;

import junit.framework.TestCase;

/**
 * Created by MM8 on 01.03.2017.
 */
public class StationeryAccountTest extends TestCase {
    public void testGetAllStationeryCost() throws Exception {
        StationeryAccount testingAccount = new StationeryAccount();
        int totalCost = 10000;
        OfficeWorker J = new OfficeWorker("J");
        J.addStationery(new Stationery("Pen", 500));
        OfficeWorker T = new OfficeWorker("J");
        T.addStationery(new Stationery("Pen", 1500));
        OfficeWorker F = new OfficeWorker("J");
        F.addStationery(new Stationery("Pen", 2500));
        OfficeWorker A = new OfficeWorker("J");
        A.addStationery(new Stationery("Pen", 3500));
        OfficeWorker B = new OfficeWorker("J");
        B.addStationery(new Stationery("Pen", 2000));

        testingAccount.addWorker(J);
        testingAccount.addWorker(T);
        testingAccount.addWorker(F);
        testingAccount.addWorker(A);
        testingAccount.addWorker(B);

        assertTrue(totalCost == testingAccount.getAllStationeryCost());
    }

}