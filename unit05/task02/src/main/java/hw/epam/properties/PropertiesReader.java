package hw.epam.properties;

import hw.epam.properties.Exceptions.NoSuchPropertyFileException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {
    String propertiesPath;
    Set<String> propertiesKeys = new HashSet<>();

    public void setDefaultPropertiesKeys() {
        propertiesKeys.add("username");
        propertiesKeys.add("password");
    }

    public void addPropertiesKey(String key) {
        propertiesKeys.add(key);
    }

    public void setPropertiesPath(String path) {
        File propertyFile = new File(path);
        if (propertyFile.isFile()) {
            propertiesPath = path;
        } else {
            throw new NoSuchPropertyFileException("Wrong properties path");
        }
    }

    public String readProperties(String path) {
        setPropertiesPath(path);
        Properties currentProperties = new Properties();
        try {
            FileInputStream propertiesInput = new FileInputStream(propertiesPath);
            currentProperties.load(propertiesInput);
        } catch (FileNotFoundException e) {
            System.out.println("probably i shouldn`t appear");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
