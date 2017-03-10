package hw.epam.bitejava;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by MM8 on 10.03.2017.
 */
public class NullTestKeyWords {

    static KeyWords testingUnit = new KeyWords();

    @Test(expected = NullPointerException.class)
    public void testingNullCharInput() throws IOException {
        testingUnit.loadInfoFromFileCharInput();
    }
    @Test(expected = NullPointerException.class)
    public void testingNullByteInput() throws IOException {
        testingUnit.loadInfoFromFileByteInput();
    }
    @Test(expected = NullPointerException.class)
    public void testingNullInByteOutput() throws IOException {
        testingUnit.writeAmountOfJavaKeysIntoNewFileByteOutput();
    }
    @Test(expected = NullPointerException.class)
    public void testingNullCharOutput() throws IOException {
        testingUnit.writeAmountOfJavaKeysIntoNewFileCharOutput();
    }
    @Test(expected = NullPointerException.class)
    public void testingNullSetOutput() throws IOException {
        testingUnit.setOutputStream(null);
    }
    @Test(expected = NullPointerException.class)
    public void testingNullSetInput() throws IOException {
        testingUnit.setOutputStream(null);
    }

}
