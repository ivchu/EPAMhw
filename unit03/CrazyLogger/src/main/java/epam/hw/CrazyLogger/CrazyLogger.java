package epam.hw.CrazyLogger;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by MM8 on 28.02.2017.
 */
public class CrazyLogger {
    private StringBuilder log = new StringBuilder("");
    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd-MM-YYYY:hh-mm");

    public void addLog(String message) {
        ZonedDateTime logMoment = ZonedDateTime.now();
        String logAddition = logMoment.format(timeFormat) + " - " + message;
        log.append(logAddition + "\n");
    }

    public String searchByDate(String dateToSearch) {
        checkDate(dateToSearch);
        StringBuilder result = new StringBuilder("");
        String stringLog = log.toString();
        String[] stringsOfLog = stringLog.split("\\n");
        for (int i = 0; i < stringsOfLog.length; i++) {
            if (stringsOfLog[i].substring(0, 16).equals(dateToSearch)) {
                result.append(stringsOfLog[i] + "\n");
            }
        }
        return result.toString();
    }

    public String searchByMessage(String messageToSearch){
        
        StringBuilder result = new StringBuilder("");
        return result.toString();
    }

    private void checkDate(String dateToSearch) {
        if (dateToSearch == null) {
            throw new NullPointerException("you should write some date in format dd-MM-YYYY:hh-mm");
        }
        timeFormat.parse(dateToSearch);

    }

    public String getLog() {
        return log.toString();
    }
}
