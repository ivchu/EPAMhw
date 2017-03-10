package hw.epam.characterset;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;
public class CharsetChangerTest {
    FileInputStream fileInputStreamUTF8 = new FileInputStream("C://ivan//java//epamhw//unit04//task03//src//main//input.txt");
    FileInputStream fileInputStreamUTF16 = new FileInputStream("C://ivan//java//epamhw//unit04//task03//src//main//output.txt");

    public CharsetChangerTest() throws FileNotFoundException {
    }

    @Test
    public void testinginfoInFilesIsSame() throws IOException {
        byte[] bytesUTF8 = new byte[fileInputStreamUTF8.available()];
        byte[] bytesUTF16 = new byte[fileInputStreamUTF16.available()];
        String stringFromUTF8 = new String(bytesUTF8, "UTF-8");
        String stringFromUTF16 = new String(bytesUTF16, "UTF-16");
        assertEquals(stringFromUTF8, stringFromUTF16);
    }
}