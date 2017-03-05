package epam.hw.CrazyLogger;

import org.junit.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

/**
 * Created by MM8 on 03.03.2017.
 */
public class CrazyLoggerTest {
    CrazyLogger logger = new CrazyLogger();
    ZonedDateTime timeOfFirstAdding;
    String forTestingSearchbyDate;
    @Test
    public void testAddLog() throws InterruptedException {
        initCrazyLogger();
        System.out.println(logger.getLog());
    }

    @Test
    public void testSearchInLog() throws Exception {
        initCrazyLogger();
        System.out.println(logger.searchByDate(forTestingSearchbyDate));
        System.out.println(logger.searchByMessage("1"));
        assertTrue(logger.searchByMessage("1").equals(logger.searchByDate(forTestingSearchbyDate)));
    }

    public void initCrazyLogger() throws InterruptedException {
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-YYYY:hh-mm");
        timeOfFirstAdding = ZonedDateTime.now();
        forTestingSearchbyDate = timeOfFirstAdding.format(timeFormat);
        logger.addLog("1");
        Thread.sleep(60000);
        logger.addLog("2");
        Thread.sleep(1000);
        logger.addLog("3");
    }

}