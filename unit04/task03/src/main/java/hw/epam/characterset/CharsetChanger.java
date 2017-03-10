package hw.epam.characterset;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CharsetChanger {
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private String infoFromFile;

    public void readFromFileUTF8(String inputStream) throws IOException {
        if (inputStream == null){
            throw new NullPointerException("inputStream cant be null");
        }
        fileInputStream = new FileInputStream(inputStream);
        byte[] bytesUTF8 = new byte[fileInputStream.available()];
        int test = fileInputStream.read(bytesUTF8);
        if (test == -1){
            throw new IOException("smth wrong with reading");
        }
        infoFromFile = new String(bytesUTF8, "UTF-8");
        fileInputStream.close();
    }

    public String changeCharsetFromUTF8ToUTF16() throws UnsupportedEncodingException {
        if (infoFromFile == null){
            throw new NullPointerException("u must read some info in UTF8");
        }
        String stringUTF16 = new String(infoFromFile.getBytes("UTF-16"), "UTF-16");
        return stringUTF16;
    }
}
