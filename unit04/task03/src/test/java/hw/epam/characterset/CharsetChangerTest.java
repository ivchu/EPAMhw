package hw.epam.characterset;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;
public class CharsetChangerTest {
    CharsetChanger testingUnit = new CharsetChanger();
    FileInputStream fileInputStreamUTF8 = new FileInputStream("C://ivan//java//epamhw//unit04//task03//src//main//input.txt");
    FileInputStream fileInputStreamUTF16 = new FileInputStream("C://ivan//java//epamhw//unit04//task03//src//main//output.txt");

    public CharsetChangerTest() throws FileNotFoundException {
    }

    @Test(expected = NullPointerException.class)
    public void testingNullInMethods() throws IOException {
        testingUnit.readFromFileUTF8(null);
        testingUnit.writeToFileInUNTF16(null);
    }

    @Test
    public void testinginfoInFilesIsSame() throws IOException {
        byte[] bytesUTF8 = new byte[fileInputStreamUTF8.available()];
        fileInputStreamUTF8.read(bytesUTF8);
        String stringFromUTF8 = new String(bytesUTF8, "UTF-8");
        testingUnit.readFromFileUTF8("C://ivan//java//epamhw//unit04//task03//src//main//input.txt");
        testingUnit.writeToFileInUNTF16("C://ivan//java//epamhw//unit04//task03//src//main//output.txt");
        byte[] bytesUTF16 = new byte[fileInputStreamUTF16.available()];
        fileInputStreamUTF16.read(bytesUTF16);
        String stringFromUTF16 = new String(bytesUTF16, "UTF-16");
        assertEquals(stringFromUTF8, stringFromUTF16);
    }


    @Test
    public void testingConvertFromUTF8ToUTF16() throws IOException {
        byte[] bytesUTF8 = new byte[fileInputStreamUTF8.available()];
        fileInputStreamUTF8.read(bytesUTF8);
        String stringFromUTF8 = new String(bytesUTF8, "UTF-8");
        testingUnit.readFromFileUTF8("C://ivan//java//epamhw//unit04//task03//src//main//input.txt");
        assertEquals(stringFromUTF8, testingUnit.changeCharsetFromUTF8ToUTF16());
    }
}