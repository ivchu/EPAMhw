package hw.epam.multithreading.properties;

import java.io.IOException;

public class PropertiesReadingThread extends Thread{
    PropertiesReaderMultiThreading propReader;

    public PropertiesReadingThread(PropertiesReaderMultiThreading propReader) {
        this.propReader = propReader;
    }

    @Override
    public void run() {
        try {
            propReader.readProperty();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
