package hw.epam.bitejava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class KeyWords {

    private FileInputStream input;
    private FileOutputStream output;
    private String infoFromfile;
    private HashMap<String, Integer> javaKeyWords = new HashMap<>();

    public void setInputStream(String fileName) throws FileNotFoundException {
        input = new FileInputStream(fileName);
    }

    public void setOutputStream(String fileName) throws FileNotFoundException {
        output = new FileOutputStream(fileName);
    }

    public void loadInfoFromFile() throws IOException {
        if (input == null) {
            throw new IOException("u must set input filestream");
        }
        if (output == null) {
            throw new IOException("u must set output filestream");
        }
        int fileLength = input.available();
        byte[] byteInfo = new byte[fileLength];
        int readResult = input.read(byteInfo);
        if (readResult == -1) {
            throw new IOException("something wrong with the file");
        }
        infoFromfile = new String(byteInfo);
    }

    public Map<String, Integer> findKeyWordsInInfoFromFile() {
        if (infoFromfile == null) {
            throw new NullPointerException("u must load some info from file");
        }
//        String str = infoFromfile.replaceAll("\\n"," ");
        String[] keyWords = infoFromfile.split("[ ;:]\\}\\{\\n");
        for (String s : keyWords){
            System.out.println(s);
            System.out.println(keyWords.length);
        }
        return Collections.unmodifiableMap(javaKeyWords);
    }

    public String getInfo() {
        return infoFromfile;
    }
}
