package epam.hw.CrazyLogger;

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
    private Pattern patternOfLineInLog = Pattern.compile("");

    public CrazyLogger() {
    }

    public void addLog(String message) {
        ZonedDateTime logMoment = ZonedDateTime.now();
        String logAddition = logMoment.format(timeFormat) + " - " + message;
        log.append(logAddition + "\n");
    }

    public String searchInLog(String info) {
        if (info == null) {
            throw new NullPointerException("you should search smth");
        }
        String stringLog = log.toString();
        if (stringLog.contains(info)) {
            int startOfInfo = stringLog.indexOf(info);
            // "\n + info + \n"
        }
        throw new NoSuchElementException();
    }

    public StringBuilder getLog() {
        return log;
    }
}
