package hw.epam.multithreading.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderMultiThreading {
    private String path;

    public PropertiesReaderMultiThreading(String path) {
        this.path = path;
    }

    public String readProperty(String key) throws IOException {
        FileInputStream propertiesInput = new FileInputStream(path);
        Properties currentProperties = new Properties();
        synchronized (Properties.class) {
            try {
                currentProperties.load(propertiesInput);
            } finally {
                propertiesInput.close();
            }
        }
        return (String) currentProperties.get(key);
    }
}