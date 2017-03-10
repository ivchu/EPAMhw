package hw.epam.bitejava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class KeyWords {

    private FileInputStream input;
    private FileOutputStream output;
    private String info;

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
        info = new String(byteInfo);
    }

    public String getInfo() {
        return info;
    }
}
