package hw.epam.htmlregex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MM8 on 03.03.2017.
 */
public class HtmlRegexAnalizer {
    private final Pattern PIC_PATTERN = Pattern.compile("\\([Рр]ис[.] \\d+\\)");
    private final Pattern SENTENCE_PATTERN = Pattern.compile("[А-ЯA-Z].*[.!?]");

    public String readTextFromFile(String file) throws FileNotFoundException {
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
            while ((line = reader.readLine()) != null) {
                textFromFile.append(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Опять что-то хуевенько читаем");
            e.printStackTrace();
        }
        return textFromFile.toString();
    }

    public boolean arePicturesInOrder(String text) {
        Matcher picMatcher = PIC_PATTERN.matcher(text);

        int picNumber = 0;

        while (picMatcher.find()) {
            int curr = Integer.valueOf(picMatcher.group().charAt(6));
            if (picNumber > curr) {
                return false;
            }
            picNumber = curr;
        }
        return true;
    }

    public String findSentencesWithPic(String text) {
        StringBuilder result = new StringBuilder("");
        Matcher sentenceMatcher = SENTENCE_PATTERN.matcher(text);
        while (sentenceMatcher.find()) {
            Matcher picMatcher = PIC_PATTERN.matcher(sentenceMatcher.group());
            if (picMatcher.find()){
                result.append(sentenceMatcher.group() + "\n");
            }
        }
        return result.toString();
    }

}
