package hw.epam.bitejava;

import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by MM8 on 10.03.2017.
 */
public class KeyWordsTest {
    static KeyWords testingUnit = new KeyWords();
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

}