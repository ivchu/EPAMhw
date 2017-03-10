package hw.epam.bitejava;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by MM8 on 10.03.2017.
 */
public class KeyWordsTest {
    static KeyWords testingUnit = new KeyWords();
    static String infoFromFile;

    static {
        try {
            testingUnit.setInputStream("C:\\ivan\\java\\epamhw\\unit04\\task01_02\\src\\main\\input.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("setInputStream i came from");
        }
        try {
            testingUnit.setOutputStream("C:\\ivan\\java\\epamhw\\unit04\\task01_02\\src\\main\\output.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("setOutputStream i came from");
        }
    }

    @Test
    public void splitingJavaKeyWordTestByteStream() throws Exception {
        testingUnit.loadInfoFromFileByteInput();
        Map<String, Integer> testingMap = testingUnit.findKeyWordsInInfoFromFile();
        for (Map.Entry<String, Integer> item : testingMap.entrySet()) {
            System.out.println(item.getKey() + "  :  " + item.getValue());
        }
    }

    @Test
    public void outputTestByteStream() throws IOException {
        testingUnit.loadInfoFromFileByteInput();
        testingUnit.findKeyWordsInInfoFromFile();
        testingUnit.writeAmountOfJavaKeysIntoNewFileByteOutput();
    }

    @Test
    public void charStreamInputtest() throws IOException {
        testingUnit.loadInfoFromFileCharInput();
        Map<String, Integer> testingMap = testingUnit.findKeyWordsInInfoFromFile();
        for (Map.Entry<String, Integer> item : testingMap.entrySet()) {
            System.out.println(item.getKey() + "  :  " + item.getValue());
        }
    }

    @Test
    public void outputTestCharStream() throws IOException {
        testingUnit.loadInfoFromFileCharInput();
        testingUnit.findKeyWordsInInfoFromFile();
        testingUnit.writeAmountOfJavaKeysIntoNewFileCharOutput();
    }
}