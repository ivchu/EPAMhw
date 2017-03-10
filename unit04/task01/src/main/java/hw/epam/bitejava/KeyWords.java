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
    private String infoForWriting;
    private HashMap<String, Integer> javaKeyWordsMap = new HashMap<>();


    /*
        collection with java key words as keys
     */
    {
        javaKeyWordsMap.put("byte", 0);
        javaKeyWordsMap.put("short", 0);
        javaKeyWordsMap.put("int", 0);
        javaKeyWordsMap.put("long", 0);
        javaKeyWordsMap.put("char", 0);
        javaKeyWordsMap.put("float", 0);
        javaKeyWordsMap.put("double", 0);
        javaKeyWordsMap.put("boolean", 0);
        javaKeyWordsMap.put("if", 0);
        javaKeyWordsMap.put("else", 0);
        javaKeyWordsMap.put("switch", 0);
        javaKeyWordsMap.put("case", 0);
        javaKeyWordsMap.put("default", 0);
        javaKeyWordsMap.put("while", 0);
        javaKeyWordsMap.put("do", 0);
        javaKeyWordsMap.put("break", 0);
        javaKeyWordsMap.put("continue", 0);
        javaKeyWordsMap.put("for", 0);
        javaKeyWordsMap.put("try", 0);
        javaKeyWordsMap.put("catch", 0);
        javaKeyWordsMap.put("finally", 0);
        javaKeyWordsMap.put("throw", 0);
        javaKeyWordsMap.put("throws", 0);
        javaKeyWordsMap.put("private", 0);
        javaKeyWordsMap.put("protected", 0);
        javaKeyWordsMap.put("public", 0);
        javaKeyWordsMap.put("import", 0);
        javaKeyWordsMap.put("package", 0);
        javaKeyWordsMap.put("class", 0);
        javaKeyWordsMap.put("interface", 0);
        javaKeyWordsMap.put("extends", 0);
        javaKeyWordsMap.put("implements", 0);
        javaKeyWordsMap.put("static", 0);
        javaKeyWordsMap.put("final", 0);
        javaKeyWordsMap.put("void", 0);
        javaKeyWordsMap.put("abstract", 0);
        javaKeyWordsMap.put("native", 0);
        javaKeyWordsMap.put("new", 0);
        javaKeyWordsMap.put("return", 0);
        javaKeyWordsMap.put("this", 0);
        javaKeyWordsMap.put("super", 0);
        javaKeyWordsMap.put("synchronized", 0);
        javaKeyWordsMap.put("volatile", 0);
        javaKeyWordsMap.put("const", 0);
        javaKeyWordsMap.put("goto", 0);
        javaKeyWordsMap.put("instanceof", 0);
        javaKeyWordsMap.put("enum", 0);
        javaKeyWordsMap.put("assert", 0);
        javaKeyWordsMap.put("transient", 0);
        javaKeyWordsMap.put("strictfp", 0);

    }


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
        String[] keyWords = infoFromfile.split("[\\s]+");
        for (String s : keyWords){
            if (javaKeyWordsMap.containsKey(s)){
                javaKeyWordsMap.put(s, javaKeyWordsMap.get(s)+1);
            }
        }
        return Collections.unmodifiableMap(javaKeyWordsMap);
    }

    private String getOutputStringFormat(){
        String result = javaKeyWordsMap.toString();
        result = result.replaceAll("[a-z]*\\{+", " ");
        result = result.replaceAll("[a-z]*\\}+", " ");
        result = result.replaceAll("\\,+", "\n");
        return result;
    }

    public void writeAmountOfJavaKeysIntoNewFile () throws IOException {
        if (output == null) {
            throw new IOException("u must set output filestream");
        }
        String stringForOutput = getOutputStringFormat();
        byte[] outputBytes = stringForOutput.getBytes();
        output.write(outputBytes);
    }

    public String getInfo() {
        return infoFromfile;
    }
}
