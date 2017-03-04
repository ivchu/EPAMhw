package epam.hw.CrazyLogger;

import org.junit.Test;

/**
 * Created by MM8 on 03.03.2017.
 */
public class CrazyLoggerTest {
    @Test
    public void addLog() throws Exception {
        CrazyLogger logger = new CrazyLogger();
        logger.addLog("1");
        Thread.sleep(1000);
        logger.addLog("2");
        Thread.sleep(1000);
        logger.addLog("3");
        System.out.println(logger.getLog());
    }

    @Test
    public void searchInLog() throws Exception {

    }

}