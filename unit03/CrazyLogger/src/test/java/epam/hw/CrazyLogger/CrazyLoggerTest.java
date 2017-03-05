package epam.hw.CrazyLogger;

import org.junit.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by MM8 on 03.03.2017.
 */
public class CrazyLoggerTest {
    @Test
    public void addLog() throws Exception {
        CrazyLogger logger = new CrazyLogger();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-YYYY:hh-mm");
        ZonedDateTime timeOfFirstAdding = ZonedDateTime.now();
        String forTestingSearchbyDate = timeOfFirstAdding.format(timeFormat);
        logger.addLog("1");
        Thread.sleep(1000);
        logger.addLog("2");
        Thread.sleep(1000);
        logger.addLog("3");
        System.out.println(logger.getLog());
    }

    @Test
    public void searchInLog() throws Exception {
        CrazyLogger logger = new CrazyLogger();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-YYYY:hh-mm");
        ZonedDateTime timeOfFirstAdding = ZonedDateTime.now();
        String forTestingSearchbyDate = timeOfFirstAdding.format(timeFormat);
    }

}