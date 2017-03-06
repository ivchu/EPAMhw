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
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1251"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("С кодировкой ошибься");
            e.printStackTrace();
        }
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

    public boolean arePicturesInOrder(String text){
        Pattern picPattern = Pattern.compile("\\([Рр]ис[.] \\d+\\)");
        Matcher picMatcher = picPattern.matcher(text);

        int picNumber = 0;

        while (picMatcher.find()){
            int curr = Integer.valueOf(picMatcher.group().charAt(6));
            if (picNumber > curr){
                return false;
            }
            picNumber = curr;
        }
        return true;
    }
}
