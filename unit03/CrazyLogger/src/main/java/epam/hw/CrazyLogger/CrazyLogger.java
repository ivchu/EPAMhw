package epam.hw.CrazyLogger;

import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

/**
 * Created by MM8 on 28.02.2017.
 */
public class CrazyLogger {
    private StringBuilder log = new StringBuilder("");
    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm");
    private Pattern searchPattern = new Pattern("");
    public CrazyLogger() throws FileNotFoundException {
    }

    public void addLog(String message){
        ZonedDateTime logMoment = ZonedDateTime.now();
        String logAddition = logMoment.format(timeFormat) + " - " + message;
        log.append(logAddition + "\n");
    }

    public String searchLog(String info){
        if (info == null){
            throw new NullPointerException();
        }
        String stringLog = log.toString();
        if (stringLog.contains(info)){
            int startOfInfo = stringLog.indexOf(info);
            // "\n + info + \n"
            stringLog.
        }
        throw new NoSuchElementException();
    }
}
