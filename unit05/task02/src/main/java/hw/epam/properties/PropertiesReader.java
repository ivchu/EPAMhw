package hw.epam.properties;

import hw.epam.properties.Exceptions.IllegalKeyForProperties;
import hw.epam.properties.Exceptions.NoSuchPropertyFileException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class PropertiesReader {
    String propertiesPath;
    List<String> propertiesKeys = new ArrayList<>();

    public void setDefaultPropertiesKeys() {
        propertiesKeys.add("password");
        propertiesKeys.add("username");
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

    public String readProperties(String path) throws IOException {
        setPropertiesPath(path);
        Properties currentProperties = new Properties();
        FileInputStream propertiesInput = new FileInputStream(propertiesPath);
        StringBuffer result = new StringBuffer("");
        try {
            currentProperties.load(propertiesInput);
        } catch (FileNotFoundException e) {
            System.out.println("probably i shouldn`t appear");
            e.printStackTrace();
        } finally {
            propertiesInput.close();
        }
        for (int i = 0; i < propertiesKeys.size(); i++) {
            if (currentProperties.containsKey(propertiesKeys.get(i))) {
                result.append(propertiesKeys.get(i) + "=" + currentProperties.getProperty(propertiesKeys.get(i)) + "\n");
            } else {
                throw new IllegalKeyForProperties("в файле нету нужных нам ключей");
            }
        }
        String forreturn = result.toString();
        return forreturn.substring(0, forreturn.length() - 1);
    }
}
