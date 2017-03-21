package hw.epam.multithreading.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesReaderMultiThreading {
    Properties currentProperties;
    private List<String> propertiesKeys = new ArrayList<>();


    public void addPropertiesKey(String key) {
        propertiesKeys.add(key);
    }

    public void readProperties(String path) throws IOException {
        FileInputStream propertiesInput = new FileInputStream(path);
        synchronized (Properties.class) {
            try {
                currentProperties.load(propertiesInput);
            } finally {
                propertiesInput.close();
            }
        }
    }
}