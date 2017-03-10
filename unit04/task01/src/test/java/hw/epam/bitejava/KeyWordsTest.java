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
            testingUnit.setInputStream("C:\\ivan\\java\\epamhw\\unit04\\task01\\src\\main\\input.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("setInputStream i came from");
        }
        try {
            testingUnit.setOutputStream("C:\\ivan\\java\\epamhw\\unit04\\task01\\src\\main\\output.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("setOutputStream i came from");
        }
    }

    @Test
    public void loadInfoFromFile() throws Exception {
        testingUnit.loadInfoFromFile();
        System.out.println(testingUnit.getInfo());
    }


    @Test
    public void splitingJavaKeyWordTest() throws Exception {
        testingUnit.loadInfoFromFile();
        Map<String, Integer> testingMap = testingUnit.findKeyWordsInInfoFromFile();
        for (Map.Entry<String, Integer> item : testingMap.entrySet()) {
            System.out.println(item.getKey() + "  :  " + item.getValue());
        }
    }

    @Test
    public void outputTest() throws IOException {
        testingUnit.loadInfoFromFile();
        testingUnit.findKeyWordsInInfoFromFile();
        testingUnit.writeAmountOfJavaKeysIntoNewFile();
    }


}