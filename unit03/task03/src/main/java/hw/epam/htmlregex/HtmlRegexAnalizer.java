package hw.epam.htmlregex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MM8 on 03.03.2017.
 */
public class HtmlRegexAnalizer {

    public String readTextFeomFile(String file) throws FileNotFoundException {
        StringBuilder textFromFile = new StringBuilder("");
        String line;
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try {
            while ((line = reader.readLine()) != null){
                textFromFile.append(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Опять что-то хуевенько читаем");
            e.printStackTrace();
        }
        return textFromFile.toString();
    }

    public boolean arePicturesInOrder() {
        boolean result = false;
        boolean contsinsPicture;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("Java.SE.03.Information handling_task_attachment"));
        } catch (FileNotFoundException e) {
            System.out.println("А файла то нету");
            e.printStackTrace();
        }
        String readedLine;
        Pattern[] picturePatterns = new Pattern[]{
                Pattern.compile(".*рис\\.[0-9]+.*"),
                Pattern.compile(".*рисунке [0-9]+.*"),
                Pattern.compile(".*рисиснок [0-9]+.*")};
        try {
            while (reader.ready()) {
                readedLine = reader.readLine();
                String lowReadedLine = readedLine.toLowerCase();
                for (int i = 0; i < 3; i++) {
                    Matcher matcher = picturePatterns[i].matcher(lowReadedLine);
                    contsinsPicture = matcher.matches();
                }
                readedLine.
            }
        } catch (IOException e) {
            System.out.println("Хуево читаем строки");
            e.printStackTrace();
        }
        return result;
    }
}
